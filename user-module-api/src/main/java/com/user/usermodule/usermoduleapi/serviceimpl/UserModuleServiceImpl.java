package com.user.usermodule.usermoduleapi.serviceimpl;

import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.User;
import com.user.usermodule.usermoduleapi.exception.ResourceNotFoundException;
import com.user.usermodule.usermoduleapi.repository.UserModuleRepository;
import com.user.usermodule.usermoduleapi.repository.UserModuleRoleRepository;
import com.user.usermodule.usermoduleapi.service.UserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * User business logic implementations layer
 * @author – Sasiprabu
 */
@Service
public class UserModuleServiceImpl implements UserModuleService {

    private final UserModuleRepository userModuleRepository;

    private final UserModuleRoleRepository userModuleRoleRepository;

    @Autowired
    public UserModuleServiceImpl(UserModuleRepository userModuleRepository, UserModuleRoleRepository userModuleRoleRepository) {
        this.userModuleRepository = userModuleRepository;
        this.userModuleRoleRepository = userModuleRoleRepository;
    }

    public List<User> getRole(String username, String password) {
        return userModuleRepository.getRole(username, password);
    }

    public UserDto addUser(UserDto userDto) {
        User user = UserDto.userDTOtoUser(userDto);
        user = userModuleRepository.save(user);
        return UserDto.userToUserDTO(user);
    }

    @Transactional
    public List<UserDto> insertAll(List<UserDto> userDtoList) {
//        return (List<User>) userModuleRepository.saveAll(user);
        List<User> userList = UserDto.userDTOtoUser(userDtoList);
        userList = (List<User>) userModuleRepository.saveAll(userList);
        return UserDto.userToUserDTO(userList);
    }

    public List<UserDto> getUserDetails() {
        List<User> userData = userModuleRepository.findAll();
        return UserDto.userToUserDTO(userData);
    }

    public UserDto getByUserName(String username) throws ResourceNotFoundException {
        User user = userModuleRepository.findByUsername(username);
        return UserDto.userToUserDTO(user);
    }

    public List<UserDto> findByRole(int roleId) {
        List<User> user = userModuleRepository.findByRoleId(roleId);
        return UserDto.userToUserDTO(user);
    }

    public UserDto updateByUser(int userid, UserDto userDto) throws ResourceNotFoundException {
        User userData = userModuleRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userid));
        userData.setUserid(userid);
        userData.setUsername(userDto.getUsername());
        userData.setPassword(userDto.getPassword());
        userData.setMobileNumber(userDto.getMobileNumber());
        User userUpdate = userModuleRepository.save(userData);
        return UserDto.userToUserDTO(userUpdate);
    }

    public List<UserDto> getUserList(String username) {
        List<User> userList = userModuleRepository.getUserList(username);
        return UserDto.userToUserDTO(userList);
    }

    public List<UserDto> getSearchList(String username) {
        List<User> userSearchList = userModuleRepository.getSearchList(username);
        return UserDto.userToUserDTO(userSearchList);
    }

    public List<UserDto> getByPage(int pageNo,int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<User> pageResult = userModuleRepository.findAll(paging);
        return UserDto.userToUserDTO(pageResult.toList());
    }

}