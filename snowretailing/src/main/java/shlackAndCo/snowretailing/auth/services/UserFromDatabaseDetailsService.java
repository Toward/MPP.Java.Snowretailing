package shlackAndCo.snowretailing.auth.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;
import shlackAndCo.snowretailing.dal.entities.PermissionsEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserFromDatabaseDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    public UserFromDatabaseDetailsService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        IUserEntity user = userRepository.getByLogin(login);
        if(user == null)
            throw new UsernameNotFoundException("Username not found");
        return new User(user.getLogin(),user.getPasswordhash(),true,true,true,
                true,getAuthorities(user.getRoleByRoleId()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(RoleEntity role) {

        return getGrantedAuthorities(getPermissions(role));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        return authorities;
    }

    private List<String> getPermissions(RoleEntity role) {
        List<String> result = new ArrayList<>();
        for (PermissionsEntity permission : role.getPermissions()) {
            result.add(permission.getDescription());
        }
        return result;
    }
}
