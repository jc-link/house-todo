package com.housetodo.domain.service;

import com.housetodo.infrastructure.entity.AppUser;
import com.housetodo.infrastructure.entity.UserGroup;

import java.util.List;

public interface AppUserService {

    AppUser saveAppUser(AppUser appUser);
    AppUser getAppUserById(String userId);
    List<AppUser> getAppUserByUserGroup(UserGroup userGroup);
    int deleteAppUser(String userId);

    AppUser updateAppUser(AppUser appUser);
}
