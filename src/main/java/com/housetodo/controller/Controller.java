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


}
