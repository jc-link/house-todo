package com.housetodo.controller;

import com.housetodo.domain.service.UserGroupService;
import com.housetodo.infrastructure.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ms")
public class Controller {

    @Autowired
    @Qualifier("userGroupService")
    private UserGroupService userGroupService;
    @GetMapping("/test")
    public String sendMessage() {
        return "Hello there test!";
    }

    @PostMapping(path = "/createGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserGroup createGroup(@RequestBody UserGroup userGroup) {
        return userGroupService.createUserGroup(userGroup);

    }
}
