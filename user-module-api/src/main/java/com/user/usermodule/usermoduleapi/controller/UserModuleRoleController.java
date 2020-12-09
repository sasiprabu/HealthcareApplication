package com.user.usermodule.usermoduleapi.controller;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.Role;
import com.user.usermodule.usermoduleapi.entity.User;
import com.user.usermodule.usermoduleapi.service.UserModuleRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Role details manipulations
 * @author – Sasiprabu
 */
@RestController
@RequestMapping("/roles")
public class UserModuleRoleController {

    private UserModuleRoleService userModuleRoleService;
    private Logger logger = LoggerFactory.getLogger(UserModuleRoleController.class);

    @Autowired
    @Lazy
    public UserModuleRoleController(UserModuleRoleService userModuleRoleService) {
        this.userModuleRoleService = userModuleRoleService;
    }

    /**
     * Register a new role for respective users
     * @Param   Identification for a new role
     * @return  the role data,if not found return a null
     * */
    @PostMapping("/")
    public RoleDto insertRoleDetails(@RequestBody RoleDto roleDto){
        Role addRole = RoleDto.dtoToEntity(roleDto);
        addRole = userModuleRoleService.insertRoleDetails(addRole);
        logger.info(" Role found : {}",addRole);
        return RoleDto.entityToDto(addRole);
    }

    /**
     * Return a specific role record based on roleId
     * @Param   roleId
     * @return  roleId
     * */
    @GetMapping("/{roleId}")
    public RoleDto getRoleById(@PathVariable int roleId){
        Role role = userModuleRoleService.getRoleById(roleId);
        return RoleDto.entityToDto(role);
    }

    /**
     * Delete the specific role data based on given role Id
     * @Param  roleId
     * @return respective role data
     * */
    @DeleteMapping("/{roleId}")
    public void deleteByUser(@PathVariable int roleId){
        userModuleRoleService.deleteByUser(roleId);
    }

    /**
     * Update the role records
     * @Param  roleId,roleDto
     * @return roleId,roleDto
     * */
    @PutMapping("/{roleId}")
    public RoleDto updateByRole(@PathVariable int roleId,
                                                  @RequestBody RoleDto roleDto) throws Exception{
        Role role = RoleDto.dtoToEntity(roleDto);
        Role update = userModuleRoleService.updateByRole(roleId,role);
        return RoleDto.entityToDto(update);
    }

    /**
     * return the all role records
     * */
    @GetMapping("/listAllRole")
    public List<RoleDto> getAllRecords(){
        List<Role> roleList = userModuleRoleService.getAllRecords();
        return RoleDto.entityToDto(roleList);
    }
}
