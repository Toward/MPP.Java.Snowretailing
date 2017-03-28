package shlackAndCo.snowretailing.auth;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.ResultModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TokenSimpleFailtureHandler implements AuthenticationFailureHandler {
    private final ObjectMapper mapper;

    public TokenSimpleFailtureHandler() {
        mapper = new ObjectMapper();
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResultModel error = new ResultModel(ResultStatus.ERROR,e.getMessage());

        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getOutputStream().print(mapper.writeValueAsString(error));
    }
}
