package com.housetodo.controller;

import com.housetodo.domain.service.TaskScheduleService;
import com.housetodo.infrastructure.entity.TaskSchedule;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.util.TaskScheduleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/taskschedule")
public class TaskScheduleController {

    @Autowired
    @Qualifier("taskScheduleService")
    private TaskScheduleService taskScheduleService;

    @PostMapping(path = "/create")
    public TaskSchedule createTaskSchedule(@RequestBody TaskSchedule taskSchedule) {
        return taskScheduleService.saveTaskSchedule(taskSchedule);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<?> getTaskScheduleById(@PathVariable String id) {
        TaskSchedule taskSchedule = taskScheduleService.getTaskSchedule(id);
        if (taskSchedule == null) {
            return new ResponseEntity<>(TaskScheduleMessage.EMPTY.getTaskScheduleMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(taskSchedule);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getTaskSchedulesByTaskId(@Valid @RequestBody UserGroup userGroup) {
        List<TaskSchedule> taskSchedules = taskScheduleService.getTaskSchedules(userGroup);
        if (taskSchedules.isEmpty()) {
            return new ResponseEntity<>(TaskScheduleMessage.EMPTY.getTaskScheduleMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(taskSchedules);
    }

    @GetMapping(path = "/completed")
    public ResponseEntity<?> getTaskSchedulesCompleted(@Valid @RequestBody UserGroup userGroup) {
        List<TaskSchedule> taskSchedules = taskScheduleService.getTaskSchedulesCompleted(userGroup);
        if (taskSchedules.isEmpty()) {
            return new ResponseEntity<>(TaskScheduleMessage.EMPTY.getTaskScheduleMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(taskSchedules);
    }

    @GetMapping(path = "/uncompleted")
    public ResponseEntity<?> getTaskSchedulesUncompleted(@Valid @RequestBody UserGroup userGroup) {
        List<TaskSchedule> taskSchedules = taskScheduleService.getTaskSchedulesUncompleted(userGroup);
        if (taskSchedules.isEmpty()) {
            return new ResponseEntity<>(TaskScheduleMessage.EMPTY.getTaskScheduleMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(taskSchedules);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTaskSchedule(@Valid @RequestBody TaskSchedule taskSchedule) {
        TaskSchedule taskScheduleResponse = taskScheduleService.updateTaskSchedule(taskSchedule);
        if (taskSchedule == null) {
            return new ResponseEntity<>(TaskScheduleMessage.NOT_FOUND.getTaskScheduleMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(taskScheduleResponse);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTaskSchedule(@PathVariable String id) {
        int serviceResponse = taskScheduleService.deleteTaskSchedule(id);
        if (serviceResponse == 1) {
            return new ResponseEntity<>(TaskScheduleMessage.DELETED.getTaskScheduleMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(TaskScheduleMessage.NOT_FOUND.getTaskScheduleMessage(), HttpStatus.NOT_FOUND);
    }
}
