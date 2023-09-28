package com.housetodo.infrastructure.entity;

import javax.persistence.*;

@Table(name = "task")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;
    private String name;

    public Task() {}

    public Task(String name) {
        this.name = name;
    }

    public int getTask_id() {
        return task_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
