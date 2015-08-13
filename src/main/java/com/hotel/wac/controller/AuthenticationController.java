package com.hotel.wac.controller;

import com.hotel.wac.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView register(@RequestParam String email,
                           @RequestParam String password){
        authService.register(email, password);
        return new ModelAndView("someView");
    }

}
