package shlackAndCo.snowretailing.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView errorPage = new ModelAndView("error");
        errorPage.addObject("error",e.getMessage());
        return errorPage;
    }
}
