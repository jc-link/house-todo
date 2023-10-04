package com.housetodo.controller;

import com.housetodo.domain.service.TaskService;
import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.util.TaskMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ms/task")
public class TaskController {
    @Autowired
    @Qualifier("taskService")
    private TaskService taskService;

    @GetMapping(path = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllTasks(@Valid @RequestBody UserGroup userGroup) {
        List<Task> tasks = taskService.getTasks(userGroup);
        if(tasks.isEmpty()) {
            return new ResponseEntity<>(TaskMessage.EMPTY.getTaskMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        if(task == null) {
            return new ResponseEntity<>(TaskMessage.EMPTY.getTaskMessage(),HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(task);
    }
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task saveTask(@Valid @RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task updateTask(@Valid @RequestBody Task task) {
        return taskService.saveTask(task);
    }
    /*@PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task updateTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }*/

    @DeleteMapping(path = "/{id}")
    public int deleteTask(@PathVariable String id) {
        return taskService.deleteTask(id);
    }


}
