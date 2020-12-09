package com.user.usermodule.usermoduleapi.controller;

import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.service.UserModuleAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserModuleAuthenticationController
 * @author – Sasiprabu
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserModuleAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private UserModuleAuthenticationService userModuleAuthenticationService;

    @Lazy
    @Autowired
    public UserModuleAuthenticationController(AuthenticationManager authenticationManager,
                                              UserModuleAuthenticationService userModuleAuthenticationService) {
        this.authenticationManager = authenticationManager;
        this.userModuleAuthenticationService = userModuleAuthenticationService;
    }

    /**
     * Generate Token and Authenticate
     * @param authRequest :- Getting username and password from authRequest
     * @return username and password to UserModuleService
     *  */
    @PostMapping("/authenticate")//standard endpoint change
    public String generateToken(@RequestBody UserDto authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Username/Password is not Valid");
        }
        return userModuleAuthenticationService.authenticationCheck(authRequest.getUsername(), authRequest.getPassword());
    }
}
