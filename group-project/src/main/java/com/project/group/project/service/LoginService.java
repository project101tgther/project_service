package com.project.group.project.service;

import com.project.group.project.Model.LoginInputModel;
import com.project.group.project.Model.LoginOutputModel;
import com.project.group.project.utils.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtGenerator jwtGenerator;

    public LoginOutputModel login(LoginInputModel loginInputModel){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginInputModel.getUsername(), loginInputModel.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new LoginOutputModel(loginInputModel.getUsername(), jwtGenerator.generateToken(authentication));
    }

    public LoginOutputModel register(LoginInputModel loginInputModel){


        return null;
    }
}
