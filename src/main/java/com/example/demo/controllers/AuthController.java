package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AuthReply;
import com.example.demo.models.Authentication;
import com.example.demo.services.performAuth;

@RestController
public class AuthController extends performAuth {

    @PostMapping("/auth")
    public AuthReply login(@RequestBody Authentication message) throws Exception {

        String uN = message.getUserName();
        String pwd = message.getPassword();
        boolean isSignUp = message.getIsSignUp();
        setUserName(uN);
        setPassword(pwd);
        setIsSignUp(isSignUp);
//        setSignUp(message.isSignUpBox());
//        System.out.println(getUserName()+getPassword()+getisSignUp());
        System.out.println(getUserName()+getPassword()+getIsSignUp());
        boolean res = authenticate();
        System.out.println("The details are  "+uN+"   "+pwd +  " " + isSignUp);
        System.out.println(new AuthReply(String.valueOf(res)));
        return new AuthReply(String.valueOf(res));

    }

}
