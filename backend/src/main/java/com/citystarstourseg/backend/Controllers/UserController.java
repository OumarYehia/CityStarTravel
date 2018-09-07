package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.UserRequest;
import com.citystarstourseg.backend.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@RestController
public class UserController {

    private UserService userService;

    /*@RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public int signUp(@RequestParam(value="userName", defaultValue="") String userName,
                            @RequestParam(value="userID") String userID,
                            @RequestParam(value="fullName") String fullName,
                            @RequestParam(value="email") String emailAddress,
                            @RequestParam(value="password") String password,
                            @RequestParam(value="mobileNumber") String mobileNumber,
                            @RequestParam(value="roleID", defaultValue="2") String roleID) throws NoSuchAlgorithmException, SQLException {


        userService = new UserService(userName,fullName,emailAddress,password,mobileNumber,roleID);
        return userService.createUser();
    }*/

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public int signUp(@RequestBody UserRequest userRequest) throws SQLException, NoSuchAlgorithmException {

        userService = new UserService(userRequest.getUserName(), userRequest.getFullName(),
                                      userRequest.getEmail(), userRequest.getPassword(),
                                      userRequest.getMobileNumber(), "2");
        return userService.createUser();
    }



    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public int signIn(@RequestBody UserRequest userRequest) throws NoSuchAlgorithmException, SQLException {

        userService = new UserService();
        return userService.signIn(userRequest.getUserName(),userRequest.getPassword());
    }



}
