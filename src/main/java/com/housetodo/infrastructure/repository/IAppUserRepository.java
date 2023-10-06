package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.AppUser;
import com.housetodo.infrastructure.entity.UserGroup;

import java.util.List;

public interface IAppUserRepository {
    AppUser save(AppUser appUser);
    AppUser findById(int userId);

    List<AppUser> findByUserGroup(UserGroup userGroup);

    int deleteByUserId(int userId);

}
