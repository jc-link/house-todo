package com.housetodo.infrastructure.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "task_schedule")
@Entity
public class TaskSchedule {
    @Column(name = "task_schedule_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskScheduleId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "do_until")
    private Date doUntil;

    private boolean completed;

    public TaskSchedule () {}

    public TaskSchedule(Task task, User user, Date doUntil) {
        this.task = task;
        this.user = user;
        this.doUntil = doUntil;
        this.completed = false;
    }

    public int getTaskScheduleId() {
        return taskScheduleId;
    }


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDoUntil() {
        return doUntil;
    }

    public void setDoUntil(Date doUntil) {
        this.doUntil = doUntil;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
