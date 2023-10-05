package com.housetodo.domain.service;

import com.housetodo.infrastructure.entity.UserGroup;

public interface UserGroupService {
    UserGroup createUserGroup(UserGroup userGroup);

    UserGroup updateUserGroup(UserGroup userGroup);

    UserGroup getUserGroup(String userGroupId);

    UserGroup getUserGroupByCode(String code);

    int deleteUserGroup(String userGroupId);
}
