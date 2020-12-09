package com.user.usermodule.usermoduleapi.repository;

import com.user.usermodule.usermoduleapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User data access implementations
 * @author – Sasiprabu
 */
@Repository
public interface UserModuleRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    List<User> findByRoleId(int roleId);

    /* Get User-Info based on UserName and Password */
    @Query("From User where user_name=?1 and password=?2")
    List<User> getRole(@Param("user_name") String user_name, @Param("password") String password);

    @Query("From User where user_name=?1")
    List<User> getUserList(@Param("user_name") String user_name);

    @Query("from User where user_name like %:user_name%")
    List<User> getSearchList(@Param("user_name") String user_name);
}
