package shlackAndCo.snowretailing.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

public class NoOpAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) {
        // TODO Auto-generated method stub
        return authentication;
    }

}
