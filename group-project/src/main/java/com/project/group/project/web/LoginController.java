package com.project.group.project.web;

import com.project.group.project.Model.LoginInputModel;
import com.project.group.project.Model.LoginOutputModel;
import com.project.group.project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements IBaseController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginOutputModel login(@RequestBody LoginInputModel loginInputModel){
        return loginService.login(loginInputModel);
    }
}
