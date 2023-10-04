package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.UserGroup;

import java.util.List;

public interface ITaskRepository {
    Task save(Task task);
    List<Task> findByUserGroup(UserGroup userGroup);
    int deleteByTaskId(int taskId);

    Task getById(int taskId);

}
