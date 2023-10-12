package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.TaskSchedule;
import com.housetodo.infrastructure.entity.UserGroup;

import java.util.List;

public interface ITaskScheduleRepository {

    TaskSchedule save(TaskSchedule taskSchedule);
    List<TaskSchedule> findByTask(Task task);

    List<TaskSchedule> findByTaskAndCompletedTrue(Task task);

    List<TaskSchedule> findByTaskAndCompletedFalse(Task task);
    List<TaskSchedule> findUncompletedByTask(Task task);

    int deleteById(int taskScheduleId);

    TaskSchedule getById(int taskScheduleId);

}
