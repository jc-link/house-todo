package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.UserGroup;

public interface IUserGroupRepository {

    UserGroup save(UserGroup userGroup);
}
