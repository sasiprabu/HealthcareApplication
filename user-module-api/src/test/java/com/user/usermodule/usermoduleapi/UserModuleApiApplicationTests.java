package com.user.usermodule.usermoduleapi;

import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.User;
import com.user.usermodule.usermoduleapi.repository.UserModuleRepository;
import com.user.usermodule.usermoduleapi.serviceimpl.UserModuleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
//@SpringBootConfiguration
//@ContextConfiguration
@RunWith(SpringRunner.class)
class UserModuleApiApplicationTests {

	@InjectMocks
	private UserModuleServiceImpl userModuleServiceImpl;

	@Mock
	private UserModuleRepository userModuleRepository;

	@Test
	public void addTest() {
		User userData = new User(1001, "prabu", "password", 747203,1001, null, null, null, null);
		UserDto userDto = new UserDto(1001, "prabu", "password", 747203,1001, null, null, null, null);
		when(userModuleRepository.save(userData)).thenReturn(userData);
		assertEquals(userDto, userModuleServiceImpl.addUser(userDto));
	}
}
