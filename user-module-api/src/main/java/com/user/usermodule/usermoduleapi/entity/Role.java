package com.user.usermodule.usermoduleapi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private int role_id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_description")
    private String roleDescription;

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private List<User> roleDetails;

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
    @Column(name = "Last_updated_Date")
    private LocalDateTime lastUpdatedDate;
}
