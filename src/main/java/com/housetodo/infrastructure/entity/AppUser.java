package com.housetodo.infrastructure.entity;

import javax.persistence.*;

@Table(name = "app_user")
@Entity
public class AppUser {
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_group_id")
    private UserGroup userGroup;

    public AppUser() {}

    public AppUser(String name, UserGroup userGroup) {
        this.name = name;
        this.userGroup = userGroup;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
