package com.housetodo.domain.implementation;

import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.ITaskRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    private static int id = 1;
    private static Task task = new Task();
    private static Task taskTwo = new Task();
    private static List<Task> tasks = new ArrayList<>();
    private static UserGroup userGroup = new UserGroup();

    @InjectMocks
    private TaskServiceImpl taskService;
    @Mock
    private ITaskRepository taskRepository;

    @BeforeAll
    public static void init() {
        task.setTaskId(id);
        task.setName("Task one");
        taskTwo.setTaskId(2);
        taskTwo.setName("Task two");
        tasks.add(task);
        tasks.add(taskTwo);
        userGroup.setUserGroupId(id);
    }
    @Test
    public void saveTaskShouldReturnATask() {
        when(taskRepository.save(task)).thenReturn(task);
        Task result = taskService.saveTask(task);
        assertEquals(task, result);
    }

    @Test
    public void getTasksShouldReturnATaskList() {
        when(taskRepository.findByUserGroup(userGroup)).thenReturn(tasks);
        List<Task> result = taskService.getTasks(userGroup);
        assertEquals(tasks, result);
    }

    @Test
    public void deleteTaskShouldReturn1() {
        int deleteTrue = 1;
        when(taskRepository.deleteByTaskId(task.getTaskId())).thenReturn(deleteTrue);
        int result = taskService.deleteTask(String.valueOf(task.getTaskId()));
        assertEquals(deleteTrue, result);
    }

    @Test
    public void getTaskByIdShouldReturnATask() {
        when(taskRepository.getById(id)).thenReturn(task);
        Task result = taskService.getTaskById(String.valueOf(id));
        assertEquals(task, result);
    }

    @Test
    public void getTaskByInvalidIdShouldReturnNull() {
        Task result = taskService.getTaskById("");
        assertNull(result);
    }
}