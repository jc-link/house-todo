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

    @Override
    public UserGroup updateUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    @Override
    public UserGroup getUserGroup(String userGroupId) {
        try {
            return userGroupRepository.getById(Integer.parseInt(userGroupId));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UserGroup getUserGroupByCode(String code) {
        return userGroupRepository.getByCode(code);
    }

    @Override
    public int deleteUserGroup(String userGroupId) {
        try {
            return userGroupRepository.deleteById(Integer.parseInt(userGroupId));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
