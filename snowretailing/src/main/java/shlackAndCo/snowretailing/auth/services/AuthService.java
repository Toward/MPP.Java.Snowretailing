package shlackAndCo.snowretailing.auth.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.auth.contracts.models.IAuthModel;
import shlackAndCo.snowretailing.auth.contracts.models.ILoginResultModel;
import shlackAndCo.snowretailing.auth.contracts.services.IAuthService;
import shlackAndCo.snowretailing.auth.contracts.services.ICryptographyService;
import shlackAndCo.snowretailing.auth.models.LoginResultModel;
import shlackAndCo.snowretailing.auth.models.Token;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.io.IOException;

@Service
public class AuthService implements IAuthService {
    private final IUserRepository userRepository;
    private final ICryptographyService cryptographyService;
    private final IMapper<IRoleEntity,IRoleModel> roleEntityToModelMapper;
    private final ObjectMapper mapper;

    @Autowired
    public AuthService(@Qualifier("userRepository") IUserRepository userRepository,
                       @Autowired @Qualifier("cryptographyService") ICryptographyService cryptographyService,
                       @Qualifier("roleEntityToModelMapper") IMapper<IRoleEntity,IRoleModel> roleEntityToModelMapper){
        this.userRepository = userRepository;
        this.cryptographyService = cryptographyService;
        this.roleEntityToModelMapper = roleEntityToModelMapper;
        mapper = new ObjectMapper();
    }

    @Override
    public ILoginResultModel Login(IAuthModel authModel){
        if (authModel == null)
            throw new IllegalArgumentException("User is null");

        IUserEntity loggingUser = userRepository.getByLogin(authModel.getLogin());
        String hashedPassword = DigestUtils.md5Hex(authModel.getPassword());
        if(loggingUser == null || !loggingUser.getPasswordHash().equals(hashedPassword))
            throw new IllegalArgumentException("User login or password is incorrect");

        Token token = new Token(authModel.getLogin(), hashedPassword);
        String tokenString;
        try {
            tokenString = mapper.writeValueAsString(token);
        } catch (IOException e) {
            return null;
        }
        return new LoginResultModel(loggingUser.getId(),loggingUser.getLogin(),
                roleEntityToModelMapper.Map(loggingUser.getRoleByRoleId()),cryptographyService.encrypt(tokenString));
    }

    @Override
    public void Register(IAuthModel authModel) {
        if (authModel == null)
            throw new IllegalArgumentException("User is null");
        if(userRepository.getByLogin(authModel.getLogin()) != null)
            throw new IllegalArgumentException("User with such login exists");

        IUserEntity newUser = map(authModel);
        userRepository.create(newUser);
    }

    @Override
    public void EditPassword(IAuthModel authModel, String newPassword) {
        if(authModel == null)
            throw new IllegalArgumentException("User is null");
        if(newPassword == null || newPassword.isEmpty())
            throw new IllegalArgumentException("New password is empty");

        IUserEntity editedUser = userRepository.getByLogin(authModel.getLogin());
        String oldHashedPassword = DigestUtils.md5Hex(authModel.getPassword());
        if(editedUser == null || !editedUser.getPasswordHash().equals(oldHashedPassword))
            throw new IllegalArgumentException("User login or password is incorrect");

        String newHashedPassword = DigestUtils.md5Hex(newPassword);
        editedUser.setPasswordHash(newHashedPassword);
        userRepository.update(editedUser);
    }

    private IUserEntity map(IAuthModel model){
        String hashedPassword = DigestUtils.md5Hex(model.getPassword());

        RoleEntity role = new RoleEntity();
        role.setId(model.getRoleId());

        IUserEntity userEntity = new UserEntity();
        userEntity.setLogin(model.getLogin());
        userEntity.setPasswordHash(hashedPassword);
        userEntity.setRoleByRoleId(role);
        return userEntity;
    }
}
