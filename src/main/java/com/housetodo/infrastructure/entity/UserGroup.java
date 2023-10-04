package com.housetodo.infrastructure.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "user_group")
@Entity
public class UserGroup {
    @Column(name = "user_group_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userGroupId;

    @NotBlank(message = "Can not be empty")
    private String name;

    @NotBlank(message = "Can not be empty")
    private String code;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private AppUser appUser;

    public UserGroup() {}

    public UserGroup(String name, String code, AppUser appUser) {
        this.name = name;
        this.code = code;
        this.appUser = appUser;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
