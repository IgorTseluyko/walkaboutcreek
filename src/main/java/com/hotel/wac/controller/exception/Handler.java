package com.hotel.wac.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mariiarudenko on 8/13/15.
 */
@ControllerAdvice
public class Handler {
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleDatabaseException(HttpServletRequest req, Exception e){
        
        ModelAndView model = new ModelAndView();
        
        model.addObject("request", req);
        model.addObject("exception", e);
        model.setViewName("exception/registrationException");
        return model;
    }
    
}
