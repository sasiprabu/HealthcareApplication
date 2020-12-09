package com.user.usermodule.usermoduleapi.service;

import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.User;
import com.user.usermodule.usermoduleapi.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User details abstractions
 * @author – Sasiprabu
 */
@Service
public interface UserModuleService {

    UserDto addUser(UserDto userDto);

    List<UserDto> getUserDetails();

    UserDto getByUserName(String username) throws ResourceNotFoundException;

    List<UserDto> findByRole(int roleId);

    UserDto updateByUser(int userid, UserDto userDto) throws ResourceNotFoundException;

    List<UserDto> getUserList(String username);

    List<UserDto> getSearchList(String username);

    List<UserDto> getByPage(int pageNo, int pageSize);

    List<UserDto> insertAll(List<UserDto> userDto);
}
