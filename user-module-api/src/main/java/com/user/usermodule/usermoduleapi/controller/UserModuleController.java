package com.user.usermodule.usermoduleapi.controller;

import com.user.usermodule.usermoduleapi.advice.UserAuditLogging;
import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.User;
import com.user.usermodule.usermoduleapi.exception.ResourceNotFoundException;
import com.user.usermodule.usermoduleapi.service.UserModuleAuthenticationService;
import com.user.usermodule.usermoduleapi.service.UserModuleService;
import com.user.usermodule.usermoduleapi.util.AuthenticationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User details implementations
 * @author – Sasiprabu
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserModuleController {

    private UserModuleService userModuleService;
    private AuthenticationUtil authenticationUtil;
    private Logger logger = LoggerFactory.getLogger(UserModuleController.class);

    @Lazy
    @Autowired
    public UserModuleController(UserModuleService userModuleService, AuthenticationUtil authenticationUtil,
                                AuthenticationManager authenticationManage){
        this.userModuleService = userModuleService;
        this.authenticationUtil = authenticationUtil;
    }

    /**
     * Register a new user for respective roles
     * @Param   Identification for a new user
     * @return  the user data,if not found return a null
     * */
    @UserAuditLogging
    @PostMapping("/")
    public UserDto addByUsers(@RequestBody UserDto userDto){
//        User addUser = UserDto.userDTOtoUser(userDto);
//        addUser = userModuleService.addUserData(addUser);
//        logger.info(" User found : {}",addUser);
//        return UserDto.userToUserDTO(addUser);
        return userModuleService.addUser(userDto);
    }

    /**
     * Add a list of users
     * */
    @UserAuditLogging
    @PostMapping("/add-users")
    public List<UserDto> insertAll (@RequestBody List<UserDto> userDto){
//        List<User> addAll = UserDto.userDTOtoUser(userDto);
//        addAll = userModuleService.insertAll(addAll);
//        logger.info(" User found : {}",addAll);
//        return UserDto.userToUserDTO(addAll);
        return userModuleService.insertAll(userDto);
    }

    /**
     * Get all user details
     * */
    @UserAuditLogging
    @GetMapping("/")
    public List<UserDto> getUserDetails() {
//        List<User> getUsers = userModuleService.findAll();
//        logger.info(" User found : {}",getUsers);
//        return UserDto.userToUserDTO(getUsers);
        return userModuleService.getUserDetails();
    }

    /**
     * Update the user records
     * @Param  userDto,userid
     * @return userid,userDto
     * */
    @PutMapping("/{userid}")
    @CachePut(value = "user")
    @UserAuditLogging
    public UserDto updateByUser(@PathVariable int userid,
                                             @RequestBody UserDto userDto) throws ResourceNotFoundException {
//        User userData = UserDto.userDTOtoUser(userDto);
//        userData = userModuleService.updateByUser(userid,userData);
//        return UserDto.userToUserDTO(userData);
        return userModuleService.updateByUser(userid,userDto);
    }

    /**
     * Get the userdetails based on username
     * @param  username
     * @return username
     * */
    @UserAuditLogging
    @GetMapping("/{username}")
    public UserDto getByUserName(@PathVariable String username) throws ResourceNotFoundException {
//        User userData =  userModuleService.getByUserName(username);
//        logger.info(" User name details : {}",userData);
//        return UserDto.userToUserDTO(userData);
        return userModuleService.getByUserName(username);
    }

    /**
     * Get the user details based on roleId
     * @param roleId
     * @return roleId
     * */
    @UserAuditLogging
    @GetMapping("/role-by/{roleId}")
    @Cacheable(value = "user", key = "#roleId")
    public List<UserDto> findByRole(@PathVariable int roleId) {
//        List<User> user = userModuleService.findByRoleId(roleId);
//        logger.info(" Role details : {}",user);
//        return UserDto.userToUserDTO(user);
        return userModuleService.findByRole(roleId);
    }

    @UserAuditLogging
    @GetMapping("/username/{username}")
    @Cacheable(value = "user", key = "#username")
    public List<UserDto> getUserList(@PathVariable String username) {
//        List<User> userDetails = userModuleService.getUserList(username);
//        return UserDto.userToUserDTO(userDetails);
        return userModuleService.getUserList(username);
    }

    /**
     * Getting the user data based on search list
     * @param username
     * @return all user records
     *  */
    @UserAuditLogging
    @GetMapping("/user-search/{username}")
    public List<UserDto> getSearchList(@PathVariable String username){
        return userModuleService.getSearchList(username);
    }

    /**
     * Getting the user data based on page index
     * @return all user records
     *  */
    @UserAuditLogging
    @GetMapping("/{pageNo}/{pageSize}")
    public List<UserDto> getByPage(@PathVariable int pageNo, @PathVariable int pageSize) {
//        List<User> pageDataList = userModuleService.getByPage(pageNo,pageSize);
//        return UserDto.userToUserDTO(pageDataList);
        return userModuleService.getByPage(pageNo,pageSize);
    }
}
