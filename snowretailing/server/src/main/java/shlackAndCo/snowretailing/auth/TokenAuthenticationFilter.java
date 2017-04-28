package shlackAndCo.snowretailing.auth;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import shlackAndCo.snowretailing.auth.contracts.services.ICryptographyService;
import shlackAndCo.snowretailing.auth.models.Token;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final AuthenticationManager authenticationManager;
    private final ICryptographyService cryptographyService;
    private final ObjectMapper mapper;

    public TokenAuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager, ICryptographyService cryptographyService) {
        super(defaultFilterProcessesUrl);
        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(new NoOpAuthenticationManager());
        setAuthenticationSuccessHandler(new TokenSimpleUrlAuthenticationSuccessHandler());
        setAuthenticationFailureHandler(new TokenSimpleFailtureHandler());

        this.authenticationManager = authenticationManager;
        this.cryptographyService = cryptographyService;
        mapper = new ObjectMapper();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String token = request.getHeader(HeaderNames.TOKEN_HEADER);
        Authentication userAuthenticationToken = parseToken(token);
        if (userAuthenticationToken == null) {
            throw new AuthenticationServiceException("Unauthorized");
        }
        return userAuthenticationToken;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response){
        if(request.getMethod().equals("OPTIONS"))
            return false;
        return true;
    }

    private Authentication parseToken(String tokenString) {
        try {
            String encryptedToken = cryptographyService.decrypt(tokenString);
            Token token = mapper.readValue(encryptedToken, Token.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(token.getName(), token.getPassword()));
        } catch (Exception e) {
            return null;
        }
    }
}
