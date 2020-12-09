package com.user.usermodule.usermoduleapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {
    private int roleId;
    private String roleName;
    private int userId;
    private String username;
    private String rollDescription;
}
