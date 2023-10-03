package com.housetodo.infrastructure.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "task")
@Entity
public class Task {
    @Column(name = "task_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @NotBlank(message = "Can not be empty!")
    private String name;

    @NotNull(message = "Must provide a valid user group!")
    @ManyToOne
    @JoinColumn(name = "user_group_id")
    private UserGroup userGroup;

    public Task() {}

    public Task(String name) {
        this.name = name;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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
