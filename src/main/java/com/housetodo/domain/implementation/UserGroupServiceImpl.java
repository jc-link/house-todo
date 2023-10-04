package com.housetodo.domain.implementation;

import com.housetodo.domain.service.UserGroupService;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.IUserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {
    @Autowired
    @Qualifier("userGroupRepository")
    private IUserGroupRepository userGroupRepository;

    public UserGroup createUserGroup(UserGroup userGroup) {
        String uniqueCode = UUID.randomUUID().toString();
        userGroup.setCode(uniqueCode);
        return userGroupRepository.save(userGroup);
    }
}
