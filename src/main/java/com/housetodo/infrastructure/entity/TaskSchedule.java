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
    @JoinColumn(name = "created_by")
    private AppUser createdUser;

    @ManyToOne
    @JoinColumn(name = "took_by")
    private AppUser tookUser;

    private boolean completed;

    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "completed_date")
    private Date completedDate;


    public TaskSchedule () {}

    public TaskSchedule(Task task, AppUser createdUser, Date creationDate) {
        this.task = task;
        this.createdUser = createdUser;
        this.creationDate = creationDate;
        this.completed = false;
    }

    public int getTaskScheduleId() {
        return taskScheduleId;
    }

    public void setTaskScheduleId(int taskScheduleId) {
        this.taskScheduleId = taskScheduleId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public AppUser getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(AppUser createdUser) {
        this.createdUser = createdUser;
    }

    public AppUser getTookUser() {
        return tookUser;
    }

    public void setTookUser(AppUser tookUser) {
        this.tookUser = tookUser;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }
}
