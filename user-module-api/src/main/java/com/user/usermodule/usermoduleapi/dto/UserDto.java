package com.user.usermodule.usermoduleapi.dto;

import com.user.usermodule.usermoduleapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserDto used for converting the dto to entity and viewers
 * @author – Sasiprabu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private int userid;
    private String username;
    private String password;
    private int mobileNumber;
    private int roleId;
    private String createdUser;
    private LocalDateTime createdDate;
    private String lastUpdatedUser;
    private LocalDateTime lastUpdatedDate;

    public static User userDTOtoUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        User user = new User();
        user.setUserid( userDto.getUserid());
        user.setUsername(userDto.getUsername());
        user.setPassword( userDto.getPassword() );
        user.setMobileNumber( userDto.getMobileNumber());
        user.setRoleId( userDto.getRoleId() );
        user.setCreatedUser(userDto.getCreatedUser());
        user.setCreatedDate(userDto.getCreatedDate());
        user.setLastUpdatedUser(userDto.getLastUpdatedUser());
        user.setLastUpdatedDate(userDto.getLastUpdatedDate());
        return user;
    }

    public static List<User> userDTOtoUser(List<UserDto> dto)
    {
        return dto.stream().map(x -> userDTOtoUser(x)).collect(Collectors.toList());
    }

    public static List<UserDto> userToUserDTO(List<User> user) {
        return	user.stream().map(x -> userToUserDTO(x)).collect(Collectors.toList());
    }

    public static UserDto userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUserid( user.getUserid());
        userDto.setUsername(user.getUsername());
        userDto.setPassword( user.getPassword() );
        userDto.setMobileNumber( user.getMobileNumber());
        userDto.setRoleId( user.getRoleId());
        userDto.setCreatedUser(user.getCreatedUser());
        userDto.setCreatedDate(user.getCreatedDate());
        userDto.setLastUpdatedUser(user.getLastUpdatedUser());
        userDto.setLastUpdatedDate(user.getLastUpdatedDate());
        return userDto;
    }
}