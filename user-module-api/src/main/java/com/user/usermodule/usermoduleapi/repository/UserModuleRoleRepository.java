package com.user.usermodule.usermoduleapi.repository;

import com.user.usermodule.usermoduleapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModuleRoleRepository extends JpaRepository<Role,Integer>{
}
