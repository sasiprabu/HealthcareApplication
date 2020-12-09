package com.user.usermodule.usermoduleapi.serviceimpl;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.entity.Role;
import com.user.usermodule.usermoduleapi.repository.UserModuleRoleRepository;
import com.user.usermodule.usermoduleapi.service.UserModuleRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserModuleRoleServiceImpl implements UserModuleRoleService {

    @Lazy
    @Autowired
    private UserModuleRoleRepository userModuleRoleRepository;

    public UserModuleRoleServiceImpl(UserModuleRoleRepository userModuleRoleRepository) {
        this.userModuleRoleRepository = userModuleRoleRepository;
    }

    @Transactional
    public Role insertRoleDetails(Role role) {
        return userModuleRoleRepository.save(role);
    }

    public Role getRoleById(int roleId) {
        return userModuleRoleRepository.getOne(roleId);
    }

    public void deleteByUser(int roleId) {
        userModuleRoleRepository.deleteById(roleId);
    }

    public Role updateByRole(int roleId, Role role) throws Exception {
        Role roleData = userModuleRoleRepository.findById(roleId)
                .orElseThrow(() -> new Exception("User not found for this id :: " + roleId));
        roleData.setRole_id(roleId);
        roleData.setRoleName(role.getRoleName());
        roleData.setRoleDescription(role.getRoleDescription());
        final Role roleUpdate = userModuleRoleRepository.save(roleData);
        return roleUpdate;
    }

    public List<Role> getAllRecords() {
        return userModuleRoleRepository.findAll();
    }
}
