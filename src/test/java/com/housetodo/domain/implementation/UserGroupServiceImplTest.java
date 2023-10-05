package com.housetodo.domain.implementation;

import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.IUserGroupRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserGroupServiceImplTest {

    private static int id = 1;
    private static String code = "d9a57999-3294-46de-b29d-edfc95c80f71";
    private static UserGroup userGroup = new UserGroup();

    @InjectMocks
    private UserGroupServiceImpl userGroupService;

    @Mock
    private IUserGroupRepository userGroupRepository;

    @BeforeAll
    public static void init() {
        userGroup.setUserGroupId(id);
        userGroup.setName("Grupo uno");
        userGroup.setCode(code);
    }
    @Test
    void createUserGroup() {
        when(userGroupRepository.save(userGroup)).thenReturn(userGroup);
        UserGroup result = userGroupService.createUserGroup(userGroup);
        assertEquals(userGroup, result);
    }

    @Test
    void updateUserGroup() {
        when(userGroupRepository.save(userGroup)).thenReturn(userGroup);
        UserGroup result = userGroupService.updateUserGroup(userGroup);
        assertEquals(userGroup, result);
    }

    @Test
    void getUserGroup() {
        when(userGroupRepository.getById(id)).thenReturn(userGroup);
        UserGroup result = userGroupService.getUserGroup(String.valueOf(id));
        assertEquals(userGroup, result);
    }

    @Test
    void getUserGroupByCode() {
        when(userGroupRepository.getByCode(code)).thenReturn(userGroup);
        UserGroup result = userGroupService.getUserGroupByCode(code);
        assertEquals(userGroup, result);
    }

    @Test
    void deleteUserGroup() {
        int deleteTrue = 1;
        when(userGroupRepository.deleteById(userGroup.getUserGroupId())).thenReturn(deleteTrue);
        int result = userGroupService.deleteUserGroup(String.valueOf(userGroup.getUserGroupId()));
        assertEquals(deleteTrue, result);
    }

    @Test
    public void GetUserGroupByInvalidShouldReturnNull() {
        UserGroup result = userGroupService.getUserGroup("");
        assertNull(result);
    }
}