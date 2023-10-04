package com.housetodo.domain.service;

import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.UserGroup;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getTasks(UserGroup userGroup);

    int deleteTask(String taskId);

    Task getTaskById(String taskId);




}
