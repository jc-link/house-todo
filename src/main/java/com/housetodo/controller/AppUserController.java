package com.housetodo.controller;

import com.housetodo.domain.service.AppUserService;
import com.housetodo.infrastructure.entity.AppUser;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.util.AppUserMessage;
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
@RequestMapping("/api/appuser")
public class AppUserController {

    @Autowired
    @Qualifier("appUserService")
    private AppUserService appUserService;

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAppUsersByUserGroup(@Valid @RequestBody UserGroup userGroup) {
        List<AppUser> appUsers = appUserService.getAppUserByUserGroup(userGroup);
        if(appUsers.isEmpty()) {
            return new ResponseEntity<>(AppUserMessage.EMPTY.getAppUserMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(appUsers);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAppUserById(@PathVariable String id) {
        AppUser appUser = appUserService.getAppUserById(id);
        if(appUser == null) {
            return new ResponseEntity<>(AppUserMessage.EMPTY.getAppUserMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(appUser);
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAppUser(@Valid @RequestBody AppUser appUser) {
        AppUser appUserResponse = appUserService.saveAppUser(appUser);
        if(appUserResponse == null) {
            return new ResponseEntity<>(AppUserMessage.EMPTY.getAppUserMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(appUserResponse);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateAppUser(@Valid @RequestBody AppUser appUser) {
        AppUser appUserResponse = appUserService.updateAppUser(appUser);
        if(appUserResponse == null) {
            return new ResponseEntity<>(AppUserMessage.NOT_FOUND.getAppUserMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(appUserResponse);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAppUser(@PathVariable String id) {
        int serviceResponse = appUserService.deleteAppUser(id);
        if (serviceResponse == 1) {
            return new ResponseEntity<>(AppUserMessage.DELETED.getAppUserMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(AppUserMessage.NOT_FOUND.getAppUserMessage(), HttpStatus.NOT_FOUND);
    }
}
