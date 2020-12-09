package com.user.usermodule.usermoduleapi.service;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserModuleRoleService {

    Role insertRoleDetails(Role role);

    Role getRoleById(int roleId);

    void deleteByUser(int roleId);

    Role updateByRole(int roleId, Role role) throws Exception;

    List<Role> getAllRecords();
}