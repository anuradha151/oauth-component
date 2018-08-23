package com.anuradha.demo.controller;

import com.anuradha.demo.model.Login;
import com.anuradha.demo.model.ResponseLogin;
import com.anuradha.demo.model.Test;
import com.anuradha.demo.model.User;
import com.anuradha.demo.security.AuthHandling;
import com.anuradha.demo.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/auth")
public class UserController {


    @PostMapping("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseLogin loginUser(@RequestBody Login login) {
        AuthHandling authHandling = new AuthHandling();
        return authHandling.loginUser(login);
    }


    @PostMapping("addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseLogin createUser(@RequestBody User user) {

//        These lines added for test purposes only

//        System.out.println("\n\n" + user + "\n\n");
//
//        AuthenticationService service = new AuthenticationService();
////        service.addUser(user);
////        return new ResponseLogin();
//        Test ruwan = new Test(1, "Ruwan");
//        Test test = service.addTest(ruwan);
//
//        return null;


        AuthHandling authHandling = new AuthHandling();
        return authHandling.createUser(user);
    }

}
