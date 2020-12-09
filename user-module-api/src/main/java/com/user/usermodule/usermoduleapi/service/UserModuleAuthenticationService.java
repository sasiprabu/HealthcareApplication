package com.user.usermodule.usermoduleapi.service;

import com.user.usermodule.usermoduleapi.entity.User;
import com.user.usermodule.usermoduleapi.repository.UserModuleRepository;
import com.user.usermodule.usermoduleapi.serviceimpl.UserModuleServiceImpl;
import com.user.usermodule.usermoduleapi.util.AuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserModuleAuthenticationService implements UserDetailsService {

    private UserModuleServiceImpl userModuleServiceImpl;
    private UserModuleRepository userModuleRepository;

    @Lazy
    @Autowired
    public UserModuleAuthenticationService(UserModuleServiceImpl userModuleServiceImpl, UserModuleRepository userModuleRepository) {
        this.userModuleServiceImpl = userModuleServiceImpl;
        this.userModuleRepository = userModuleRepository;
    }

    public String authenticationCheck(String username, String password) {
        List<User> role = userModuleServiceImpl.getRole(username, password);
        String token = AuthenticationUtil.generateToken(username);
        String result = "Token_Generated ".concat(token);
        return result;
    }

    public UserDetails loadUserByUsername(String username) {
        User user = userModuleRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
