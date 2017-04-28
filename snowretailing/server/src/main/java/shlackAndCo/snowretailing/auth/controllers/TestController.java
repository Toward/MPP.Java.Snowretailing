package shlackAndCo.snowretailing.auth.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shlackAndCo.snowretailing.core.constants.Permissions;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.models.ResultModel;

@RestController
public class TestController { //TODO remove after testing

    @ResponseBody
    @Secured(Permissions.UserRead)
    @RequestMapping(value = "api/test",method = RequestMethod.GET)
    public ResultModel<String> Test(){
        return new ResultModel<>(ResultStatus.OK, "Success", SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
