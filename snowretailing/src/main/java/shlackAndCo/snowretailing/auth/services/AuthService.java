package shlackAndCo.snowretailing.auth.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.auth.contracts.services.IAuthService;
import shlackAndCo.snowretailing.auth.contracts.services.ICryptographyService;
import shlackAndCo.snowretailing.auth.models.Token;
import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.core.enums.Role;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IRoleRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.io.IOException;

@Service
public class AuthService implements IAuthService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final ICryptographyService cryptographyService;
    private final ObjectMapper mapper;

    @Autowired
    public AuthService(@Qualifier("userRepository") IUserRepository userRepository,
                       @Qualifier("roleRepository") IRoleRepository roleRepository,
                       @Autowired @Qualifier("cryptographyService") ICryptographyService cryptographyService){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.cryptographyService = cryptographyService;
        mapper = new ObjectMapper();
    }

    @Override
    public String Login(IUserModel user){
        if (user == null)
            throw new IllegalArgumentException("User is null");

        IUserEntity loggingUser = userRepository.getByLogin(user.getLogin());
        String hashedPassword = DigestUtils.md5Hex(user.getPassword());
        if(loggingUser == null || !loggingUser.getPasswordhash().equals(hashedPassword))
            throw new IllegalArgumentException("User login or password is incorrect");
        Token token = new Token(user.getLogin(), hashedPassword);
        String tokenString;
        try {
            tokenString = mapper.writeValueAsString(token);
        } catch (IOException e) {
            return null;
        }
        String encryptedToken = cryptographyService.encrypt(tokenString);
        return encryptedToken;
    }

    @Override
    public void Register(IUserModel user,Role role) {
        if (user == null)
            throw new IllegalArgumentException("User is null");
        if(role == null)
            throw new IllegalArgumentException("Role is null");
        if(userRepository.getByLogin(user.getLogin()) != null)
            throw new IllegalArgumentException("User with such login exists");

        String hashedPassword = DigestUtils.md5Hex(user.getPassword());
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(roleRepository.getByRoleName(role.toString()).getId());

        IUserEntity newUser = new UserEntity();
        newUser.setLogin(user.getLogin());
        newUser.setPasswordhash(hashedPassword);
        newUser.setRoleByRoleId(roleEntity);

        userRepository.create(newUser);
    }

    @Override
    public void EditPassword(IUserModel user, String newPassword) {
        if(user == null)
            throw new IllegalArgumentException("User is null");
        if(newPassword == null || newPassword.isEmpty())
            throw new IllegalArgumentException("New password is empty");

        IUserEntity editedUser = userRepository.getByLogin(user.getLogin());
        String oldHashedPassword = DigestUtils.md5Hex(user.getPassword());
        if(editedUser == null || !editedUser.getPasswordhash().equals(oldHashedPassword))
            throw new IllegalArgumentException("User login or password is incorrect");

        String newHashedPassword = DigestUtils.md5Hex(newPassword);
        editedUser.setPasswordhash(newHashedPassword);
        userRepository.update(editedUser);
    }
}
