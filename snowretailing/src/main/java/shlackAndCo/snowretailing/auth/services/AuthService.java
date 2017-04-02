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
import shlackAndCo.snowretailing.core.contracts.services.IRoleService;
import shlackAndCo.snowretailing.core.contracts.services.IUserService;

import java.io.IOException;

@Service
public class AuthService implements IAuthService {
    private final IUserService userService;
    private final ICryptographyService cryptographyService;
    private final ObjectMapper mapper;

    @Autowired
    public AuthService(@Qualifier("userService") IUserService userService,
                       @Autowired @Qualifier("cryptographyService") ICryptographyService cryptographyService){
        this.userService = userService;
        this.cryptographyService = cryptographyService;
        mapper = new ObjectMapper();
    }

    @Override
    public String Login(IUserModel user){
        if (user == null)
            throw new IllegalArgumentException("User is null");

        IUserModel loggingUser = userService.getByLogin(user.getLogin());
        String hashedPassword = DigestUtils.md5Hex(user.getPasswordHash());
        if(loggingUser == null || !loggingUser.getPasswordHash().equals(hashedPassword))
            throw new IllegalArgumentException("User login or password is incorrect");

        Token token = new Token(user.getLogin(), hashedPassword);
        String tokenString;
        try {
            tokenString = mapper.writeValueAsString(token);
        } catch (IOException e) {
            return null;
        }
        return cryptographyService.encrypt(tokenString);
    }

    @Override
    public void Register(IUserModel user) {
        if (user == null)
            throw new IllegalArgumentException("User is null");
        if(userService.getByLogin(user.getLogin()) != null)
            throw new IllegalArgumentException("User with such login exists");

        String hashedPassword = DigestUtils.md5Hex(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);

        userService.create(user);
    }

    @Override
    public void EditPassword(IUserModel user, String newPassword) {
        if(user == null)
            throw new IllegalArgumentException("User is null");
        if(newPassword == null || newPassword.isEmpty())
            throw new IllegalArgumentException("New password is empty");

        IUserModel editedUser = userService.getByLogin(user.getLogin());
        String oldHashedPassword = DigestUtils.md5Hex(user.getPasswordHash());
        if(editedUser == null || !editedUser.getPasswordHash().equals(oldHashedPassword))
            throw new IllegalArgumentException("User login or password is incorrect");

        String newHashedPassword = DigestUtils.md5Hex(newPassword);
        editedUser.setPasswordHash(newHashedPassword);
        userService.edit(editedUser);
    }
}
