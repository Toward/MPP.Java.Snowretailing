package shlackAndCo.snowretailing.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.auth.contracts.models.IAuthModel;
import shlackAndCo.snowretailing.auth.contracts.models.ILoginResultModel;
import shlackAndCo.snowretailing.auth.contracts.services.IAuthService;
import shlackAndCo.snowretailing.auth.models.AuthModel;
import shlackAndCo.snowretailing.auth.models.EditPasswordModel;
import shlackAndCo.snowretailing.auth.models.LoginModel;
import shlackAndCo.snowretailing.auth.models.RegisterModel;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.enums.Role;
import shlackAndCo.snowretailing.core.models.ResultModel;

@RestController
public class AuthController {
    private final IAuthService authService;

    @Autowired
    public AuthController(@Qualifier("authService") IAuthService authService){
        this.authService = authService;
    }

    @ResponseBody
    @RequestMapping(value = "/auth/login",method = RequestMethod.POST)
    public IResultModel<ILoginResultModel> Login(@RequestBody @Validated LoginModel loginModel){
        ILoginResultModel result = authService.Login(map(loginModel));
        return new ResultModel<>(ResultStatus.OK, "Login successful", result);
    }

    @ResponseBody
    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public IResultModel<ILoginResultModel> Register (@RequestBody @Validated RegisterModel registerModel){
        IAuthModel user = map(registerModel,Role.USER);
        authService.Register(user);
        ILoginResultModel result = authService.Login(user);
        return new ResultModel<>(ResultStatus.OK, "Register successful", result);
    }

    @ResponseBody
    @RequestMapping(value = "/api/auth/editPassword", method = RequestMethod.POST)
    public IResultModel<ILoginResultModel> EditPassword(@RequestBody @Validated EditPasswordModel editPasswordModel){
        if(!editPasswordModel.getLogin().equals(SecurityContextHolder.getContext().getAuthentication().getName()))
            throw new IllegalArgumentException("The login is not equal to the current one");

        IAuthModel user = map(editPasswordModel);
        String newPassword = editPasswordModel.getNewPassword();
        authService.EditPassword(user,newPassword);
        user.setPassword(newPassword);
        ILoginResultModel result = authService.Login(user);
        return new ResultModel<>(ResultStatus.OK, "Password edit successful", result);
    }

    private IAuthModel map(LoginModel loginModel){
        return new AuthModel(loginModel.getLogin(),loginModel.getPassword());
    }

    private IAuthModel map(RegisterModel registerModel, Role role){
        IAuthModel userModel =  new AuthModel(registerModel.getLogin(),registerModel.getPassword());
        userModel.setRoleId(role.getIndex());
        return userModel;
    }

    private IAuthModel map(EditPasswordModel editPasswordModel){
        return new AuthModel(editPasswordModel.getLogin(),editPasswordModel.getOldPassword());
    }
}
