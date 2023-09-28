package com.housetodo.infrastructure.entity;

import javax.persistence.*;

@Table(name = "user_group")
@Entity
public class UserGroup {
    @Column(name = "user_group_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userGroupId;

    private String name;
    private String code;

    public UserGroup() {}

    public UserGroup(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public int getUserGroupId() {
        return userGroupId;
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
}
