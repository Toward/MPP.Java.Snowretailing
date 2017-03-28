package shlackAndCo.snowretailing.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import shlackAndCo.snowretailing.core.enums.ResultStatus;
import shlackAndCo.snowretailing.core.contracts.models.IResultModel;
import shlackAndCo.snowretailing.core.models.ResultModel;

@ControllerAdvice
public class ExceptionController {
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception e) {
//        ModelAndView errorPage = new ModelAndView("error");
//        errorPage.addObject("error",e.getMessage());
//        return errorPage;
//    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public IResultModel handleException(Exception e) {
        return new ResultModel(ResultStatus.ERROR,e.getMessage());
    }
}
