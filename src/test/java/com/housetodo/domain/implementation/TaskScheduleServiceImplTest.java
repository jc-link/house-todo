package com.housetodo.domain.implementation;

import com.housetodo.infrastructure.entity.AppUser;
import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.TaskSchedule;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.ITaskRepository;
import com.housetodo.infrastructure.repository.ITaskScheduleRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskScheduleServiceImplTest {

    private static int id = 1;
    private static TaskSchedule taskScheduleOne = new TaskSchedule();
    private static TaskSchedule taskScheduleTwo = new TaskSchedule();

    private static List<TaskSchedule> taskSchedules = new ArrayList<>();
    private static Task task = new Task();
    private static AppUser userCreate = new AppUser();

    private static UserGroup userGroup = new UserGroup();
    private static List<Task> tasks = new ArrayList<>();
    private static List<TaskSchedule> completedTasks = new ArrayList<>();
    private static List<TaskSchedule> uncompletedTasks = new ArrayList<>();

    @InjectMocks
    private TaskScheduleServiceImpl taskScheduleService;

    @Mock
    private ITaskScheduleRepository taskScheduleRepository;
    @Mock
    private ITaskRepository taskRepository;

    @BeforeAll
    public static void init() {
        userGroup.setUserGroupId(id);
        userGroup.setName("Family one");
        task.setTaskId(id);
        task.setName("Do this task");
        task.setUserGroup(userGroup);
        userCreate.setUserId(id);
        taskScheduleOne.setTaskScheduleId(id);
        taskScheduleOne.setTask(task);
        taskScheduleOne.setCompleted(false);
        taskScheduleTwo.setTaskScheduleId(2);
        taskScheduleTwo.setTask(task);
        taskScheduleTwo.setCompleted(true);
        taskSchedules.add(taskScheduleOne);
        taskSchedules.add(taskScheduleTwo);
        tasks.add(task);
        completedTasks.add(taskScheduleTwo);
        uncompletedTasks.add(taskScheduleOne);
    }

    @Test
    void saveTaskSchedule() {
        System.out.println(taskScheduleOne.getTaskScheduleId());
        when(taskScheduleRepository.save(taskScheduleOne)).thenReturn(taskScheduleOne);
        TaskSchedule result = taskScheduleService.saveTaskSchedule(taskScheduleOne);
        assertEquals(taskScheduleOne, result);
    }

    @Test
    void getTaskSchedules() {
        when(taskRepository.findByUserGroup(userGroup)).thenReturn(tasks);
        when(taskScheduleRepository.findByTask(task)).thenReturn(taskSchedules);
        List<TaskSchedule> result = taskScheduleService.getTaskSchedules(userGroup);
        assertEquals(taskSchedules, result);
    }

    @Test
    void getTaskSchedulesCompleted() {
        when(taskRepository.findByUserGroup(userGroup)).thenReturn(tasks);
        when(taskScheduleRepository.findByTaskAndCompletedTrue(task)).thenReturn(completedTasks);
        List<TaskSchedule> result = taskScheduleService.getTaskSchedulesCompleted(userGroup);
        assertEquals(completedTasks, result);
    }

    @Test
    void getTaskSchedulesUncompleted() {
        when(taskRepository.findByUserGroup(userGroup)).thenReturn(tasks);
        when(taskScheduleRepository.findByTaskAndCompletedFalse(task)).thenReturn(uncompletedTasks);
        List<TaskSchedule> result = taskScheduleService.getTaskSchedulesUncompleted(userGroup);
        assertEquals(uncompletedTasks, result);
    }

    @Test
    void deleteTaskSchedule() {
        int deleteTrue = 1;
        when(taskScheduleRepository.deleteById(id)).thenReturn(deleteTrue);
        int result = taskScheduleService.deleteTaskSchedule(String.valueOf(id));
        assertEquals(deleteTrue, result);
    }

    @Test
    void getTaskSchedule() {
        when(taskScheduleRepository.getById(id)).thenReturn(taskScheduleOne);
        TaskSchedule result = taskScheduleService.getTaskSchedule(String.valueOf(id));
        assertEquals(taskScheduleOne, result);
    }

    @Test
    void updateTaskSchedule() {
        when(taskScheduleRepository.getById(id)).thenReturn(taskScheduleOne);
        when(taskScheduleRepository.save(taskScheduleOne)).thenReturn(taskScheduleOne);
        TaskSchedule result = taskScheduleService.updateTaskSchedule(taskScheduleOne);
        assertEquals(taskScheduleOne, result);
    }
}