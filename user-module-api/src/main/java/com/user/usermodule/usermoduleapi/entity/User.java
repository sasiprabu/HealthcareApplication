package com.user.usermodule.usermoduleapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userid;

    @Column(name = "user_name", length = 100)
    private String username;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "mobile_no")
    private int mobileNumber;

    @Column(name = "role_id")
    private int roleId;

    @CreatedBy
    @Column(name = "created_user", updatable = false)
    private String createdUser;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;

    @LastModifiedDate
    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;
}
