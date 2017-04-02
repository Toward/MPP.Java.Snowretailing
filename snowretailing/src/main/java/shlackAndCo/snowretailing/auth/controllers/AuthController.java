package shlackAndCo.snowretailing.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shlackAndCo.snowretailing.auth.contracts.services.IAuthService;
import shlackAndCo.snowretailing.auth.models.EditPasswordModel;
import shlackAndCo.snowretailing.auth.models.LoginModel;
import shlackAndCo.snowretailing.auth.models.RegisterModel;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.contracts.services.IRoleService;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.core.enums.Role;
import shlackAndCo.snowretailing.core.models.ResultModel;
import shlackAndCo.snowretailing.core.models.RoleModel;
import shlackAndCo.snowretailing.core.models.UserModel;

@RestController
public class AuthController {
    private final IAuthService authService;
    private final IRoleService roleService;

    @Autowired
    public AuthController(@Qualifier("authService") IAuthService authService,
                          @Qualifier("roleService") IRoleService roleService){
        this.authService = authService;
        this.roleService = roleService;
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public IResultModel<String> Login(@RequestBody @Validated LoginModel loginModel){
        String token = authService.Login(map(loginModel));
        return new ResultModel<>(ResultStatus.OK, "Login successful.Token in data", token);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public IResultModel<String> Register(@RequestBody @Validated RegisterModel registerModel){
        IUserModel user = map(registerModel,Role.USER);
        authService.Register(user);
        user.setPasswordHash(registerModel.getPassword());
        String token = authService.Login(user);
        return new ResultModel<>(ResultStatus.OK, "Register successful.New token in data", token);
    }

    @ResponseBody
    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    public IResultModel<String> EditPassword(@RequestBody @Validated EditPasswordModel editPasswordModel){
        IUserModel user = map(editPasswordModel);
        String newPassword = editPasswordModel.getNewPassword();
        authService.EditPassword(user,newPassword);
        user.setPasswordHash(newPassword);
        String token = authService.Login(user);
        return new ResultModel<>(ResultStatus.OK, "Password edit successful.New token in data", token);
    }

    private IUserModel map(LoginModel loginModel){
        return new UserModel(loginModel.getLogin(),loginModel.getPassword());
    }

    private IUserModel map(RegisterModel registerModel,Role role){
        IUserModel userModel =  new UserModel(registerModel.getLogin(),registerModel.getPassword());
        IRoleModel roleModel = roleService.getByRoleName(role.toString());
        userModel.setRole(roleModel);
        return userModel;
    }

    private IUserModel map(EditPasswordModel editPasswordModel){
        return new UserModel(editPasswordModel.getLogin(),editPasswordModel.getOldPassword());
    }
}
