package com.housetodo.domain.service;

import com.housetodo.infrastructure.entity.TaskSchedule;
import com.housetodo.infrastructure.entity.UserGroup;

import java.util.List;

public interface TaskScheduleService {
    TaskSchedule saveTaskSchedule(TaskSchedule taskSchedule);
    List<TaskSchedule> getTaskSchedules(UserGroup userGroup);
    List<TaskSchedule> getTaskSchedulesCompleted(UserGroup userGroup);
    List<TaskSchedule> getTaskSchedulesUncompleted(UserGroup userGroup);
    int deleteTaskSchedule(String id);
    TaskSchedule getTaskSchedule(String id);
    TaskSchedule updateTaskSchedule(TaskSchedule taskSchedule);
}
