package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.UserGroup;

public interface IUserGroupRepository {

    UserGroup save(UserGroup userGroup);

    int deleteById(int userGroupId);
    UserGroup getById(int userGroupId);

    UserGroup getByCode(String code);
}
