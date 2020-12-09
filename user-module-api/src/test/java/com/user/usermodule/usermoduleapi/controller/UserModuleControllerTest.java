package com.user.usermodule.usermoduleapi.controller;

import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.User;
import com.user.usermodule.usermoduleapi.repository.UserModuleRepository;
import com.user.usermodule.usermoduleapi.serviceimpl.UserModuleServiceImpl;
//import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@SpringBootConfiguration
@ContextConfiguration
public class UserModuleControllerTest {

    @InjectMocks
    private UserModuleServiceImpl userModuleServiceImpl;

    @Mock
    private UserModuleRepository userModuleRepository;

    private MockMvc mockMvc;
    
//    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(UserModuleController.class).build();
    }

    @Test
    public void addTest() {
        User userData = new User(1000, "sasiprabu", "password", 747203,1000, null, null, null, null);
        UserDto userDto = new UserDto(1000, "sasiprabu", "password", 63482,1000, null, null, null, null);
        when(userModuleRepository.save(userData)).thenReturn(userData);
        assertEquals(userDto, UserDto.userToUserDTO((List<User>) userModuleServiceImpl.addUser(userDto)));
    }
}
