package com.housetodo.domain.implementation;

import com.housetodo.domain.service.TaskService;
import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    @Qualifier("taskRepository")
    private ITaskRepository taskRepository;
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks(UserGroup userGroup) {
        return taskRepository.findByUserGroup(userGroup);
    }

    @Override
    public int deleteTask(String taskId) {
        try {
            return taskRepository.deleteByTaskId(Integer.parseInt(taskId));
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public Task getTaskById(String id) {
        try {
            return taskRepository.getById(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


}
