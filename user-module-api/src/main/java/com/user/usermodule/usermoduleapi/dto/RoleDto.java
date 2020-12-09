package com.user.usermodule.usermoduleapi.dto;

import com.user.usermodule.usermoduleapi.entity.Role;
import com.user.usermodule.usermoduleapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {
    private int role_id;

    private String roleName;

    private String roleDescription;

    private List<User> roleDetails;

    private String createdUser;

    private LocalDateTime createdDate;

    private String lastUpdatedUser;

    private LocalDateTime lastUpdatedDate;

    public static Role dtoToEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }
        Role role = new Role();
        role.setRole_id( roleDto.getRole_id());
        role.setRoleName(roleDto.getRoleName());
        role.setRoleDescription( roleDto.getRoleDescription() );
        role.setRoleDetails( roleDto.getRoleDetails());
        role.setCreatedUser(roleDto.getCreatedUser());
        role.setCreatedDate(roleDto.getCreatedDate());
        role.setLastUpdatedUser(roleDto.getLastUpdatedUser());
        role.setLastUpdatedDate(roleDto.getLastUpdatedDate());
        return role;
    }

    public static List<Role> dtoToEntity(List<RoleDto> dto)
    {
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

    public static List<RoleDto> entityToDto(List<Role> role) {
        return	role.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public static RoleDto entityToDto(Role role) {
        if ( role == null ) {
            return null;
        }
        RoleDto roleDto = new RoleDto();
        role.setRole_id( roleDto.getRole_id());
        role.setRoleName(roleDto.getRoleName());
        role.setRoleDescription( roleDto.getRoleDescription() );
        role.setRoleDetails( roleDto.getRoleDetails());
        role.setCreatedUser(roleDto.getCreatedUser());
        role.setCreatedDate(roleDto.getCreatedDate());
        role.setLastUpdatedUser(roleDto.getLastUpdatedUser());
        role.setLastUpdatedDate(roleDto.getLastUpdatedDate());
        return roleDto;
    }
}
