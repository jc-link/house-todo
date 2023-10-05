package com.housetodo.controller;

import com.housetodo.domain.service.UserGroupService;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.util.TaskMessage;
import com.housetodo.util.UserGroupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usergroup")
public class UserGroupController {

    @Autowired
    @Qualifier("userGroupService")
    private UserGroupService userGroupService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserGroup createGroup(@RequestBody UserGroup userGroup) {
        return userGroupService.createUserGroup(userGroup);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<?> getUserGroupById(@PathVariable String id) {
        UserGroup userGroup = userGroupService.getUserGroup(id);
        if(userGroup == null) {
            return new ResponseEntity<>(UserGroupMessage.EMPTY.getUserGroupMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userGroup);
    }

    @GetMapping(path = "/code/{code}")
    public ResponseEntity<?> getUserGroupByCode(@PathVariable String code) {
        UserGroup userGroup = userGroupService.getUserGroupByCode(code);
        if(userGroup == null) {
            return new ResponseEntity<>(UserGroupMessage.EMPTY.getUserGroupMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userGroup);
    }

    @PutMapping
    public UserGroup updateUserGroup(@Valid @RequestBody UserGroup userGroup) {
        return userGroupService.updateUserGroup(userGroup);
    }

    @DeleteMapping(path = "/{id}")
    public int deleteUserGroup(@PathVariable String id) {
        return userGroupService.deleteUserGroup(id);
    }
}
