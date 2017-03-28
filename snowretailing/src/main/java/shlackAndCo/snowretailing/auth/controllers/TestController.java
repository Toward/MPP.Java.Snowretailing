package shlackAndCo.snowretailing.auth.controllers;

import org.springframework.security.access.annotation.Secured;
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
    @Secured(Permissions.RootRead)
    @RequestMapping(value = "api/test",method = RequestMethod.GET)
    public ResultModel Test(){
        return new ResultModel(ResultStatus.OK,"Success");
    }
}
