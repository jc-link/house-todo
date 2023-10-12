package com.housetodo.domain.implementation;

import com.housetodo.domain.service.TaskScheduleService;
import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.TaskSchedule;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.ITaskRepository;
import com.housetodo.infrastructure.repository.ITaskScheduleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("taskScheduleService")
public class TaskScheduleServiceImpl implements TaskScheduleService {

    @Autowired
    @Qualifier("taskScheduleRepository")
    private ITaskScheduleRepository taskScheduleRepository;

    @Autowired
    @Qualifier("taskRepository")
    private ITaskRepository taskRepository;

    private static final Logger logger = LogManager.getLogger();

    @Override
    public TaskSchedule saveTaskSchedule(TaskSchedule taskSchedule) {
        return taskScheduleRepository.save(taskSchedule);
    }

    @Override
    public List<TaskSchedule> getTaskSchedules(UserGroup userGroup) {
        List<TaskSchedule> taskSchedules = new ArrayList<>();
        List<Task> tasks = taskRepository.findByUserGroup(userGroup);
        for (Task task: tasks) {
            taskSchedules.addAll(taskScheduleRepository.findByTask(task));
        }
        return taskSchedules;
    }

    @Override
    public List<TaskSchedule> getTaskSchedulesCompleted(UserGroup userGroup) {
        List<TaskSchedule> taskSchedules = new ArrayList<>();
        List<Task> tasks = taskRepository.findByUserGroup(userGroup);
        for (Task task: tasks) {
            taskSchedules.addAll(taskScheduleRepository.findByTaskAndCompletedTrue(task));
        }
        return taskSchedules;
    }

    @Override
    public List<TaskSchedule> getTaskSchedulesUncompleted(UserGroup userGroup) {
        List<TaskSchedule> taskSchedules = new ArrayList<>();
        List<Task> tasks = taskRepository.findByUserGroup(userGroup);
        for (Task task: tasks) {
            taskSchedules.addAll(taskScheduleRepository.findByTaskAndCompletedFalse(task));
        }
        return taskSchedules;
    }

    @Override
    public int deleteTaskSchedule(String id) {
        try {
            return taskScheduleRepository.deleteById(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            logger.warn("Parsing error at deleteUser" + e);
            return 0;
        }
    }

    @Override
    public TaskSchedule getTaskSchedule(String id) {
        try {
            return taskScheduleRepository.getById(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            logger.warn("Parsing error" + e);
            return null;
        }
    }

    @Override
    public TaskSchedule updateTaskSchedule(TaskSchedule taskSchedule) {
        try {
            TaskSchedule taskScheduleExist = taskScheduleRepository.getById(taskSchedule.getTaskScheduleId());
            if(taskScheduleExist == null) {
                return null;
            }
            return taskScheduleRepository.save(taskSchedule);
        } catch (Exception e) {
            logger.warn(e);
            return null;
        }
    }
}
