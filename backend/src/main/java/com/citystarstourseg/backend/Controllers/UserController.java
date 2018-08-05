package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.Services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@RestController
public class UserController {

    private UserService userService;

    @RequestMapping("/signUp")
    public int userService(@RequestParam(value="userName", defaultValue="") String userName,
                            @RequestParam(value="fullName", defaultValue="") String fullName,
                            @RequestParam(value="emailAddress", defaultValue="") String emailAddress,
                            @RequestParam(value="password", defaultValue="") String password,
                            @RequestParam(value="mobileNumber", defaultValue="") String mobileNumber,
                            @RequestParam(value="roleID", defaultValue="") String roleID) throws NoSuchAlgorithmException, SQLException {

        userService = new UserService(userName,fullName,emailAddress,password,mobileNumber,roleID);
        return userService.createUser();
    }

    @RequestMapping("/signIn")
    public int userService(@RequestParam(value="userName", defaultValue="") String userName,
                           @RequestParam(value="password", defaultValue="") String password) throws NoSuchAlgorithmException, SQLException {

        userService = new UserService();
        return userService.signInCheck(userName,password);
    }





}
