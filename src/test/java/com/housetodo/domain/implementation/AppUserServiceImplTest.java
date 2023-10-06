package com.housetodo.domain.implementation;

import com.housetodo.infrastructure.entity.AppUser;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.IAppUserRepository;
import com.housetodo.infrastructure.repository.IUserGroupRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppUserServiceImplTest {

    private static int id = 1;
    private static UserGroup userGroup = new UserGroup();

    private static AppUser appUser = new AppUser();

    private static AppUser secondAppUser = new AppUser();

    private static List<AppUser> appUsers = new ArrayList<>();
    @InjectMocks
    private AppUserServiceImpl appUserService;

    @Mock
    private IAppUserRepository appUserRepository;

    @Mock
    private IUserGroupRepository userGroupRepository;

    @BeforeAll
    public static void init() {
        appUser.setUserId(id);
        appUser.setName("Edward Lee");
        userGroup.setUserGroupId(id);
        appUser.setUserGroup(userGroup);
        secondAppUser.setUserId(2);
        secondAppUser.setName("Elon Musk");
        secondAppUser.setUserGroup(userGroup);
        appUsers.add(appUser);
        appUsers.add(secondAppUser);
    }
    @Test
    void saveAppUser() {
        when(userGroupRepository.getById(id)).thenReturn(userGroup);
        when(appUserRepository.save(appUser)).thenReturn(appUser);
        AppUser result = appUserService.saveAppUser(appUser);
        assertEquals(appUser, result);
    }

    @Test
    void getAppUserById() {
        when(appUserRepository.findById(id)).thenReturn(appUser);
        AppUser result = appUserService.getAppUserById(String.valueOf(id));
        assertEquals(appUser, result);
    }

    @Test
    void getAppUserByUserGroup() {
        when(appUserRepository.findByUserGroup(userGroup)).thenReturn(appUsers);
        List<AppUser> result = appUserService.getAppUserByUserGroup(userGroup);
        assertEquals(appUsers, result);
    }

    @Test
    void deleteAppUser() {
        int deleteTrue = 1;
        when(appUserRepository.deleteByUserId(id)).thenReturn(deleteTrue);
        int result = appUserService.deleteAppUser(String.valueOf(id));
        assertEquals(deleteTrue, result);
    }

    @Test
    void updateAppUser() {
        when(appUserRepository.findById(id)).thenReturn(appUser);
        when(appUserRepository.save(appUser)).thenReturn(appUser);
        AppUser result = appUserService.updateAppUser(appUser);
        assertEquals(appUser, result);
    }

    @Test
    public void getAppUserByInvalidIdShouldReturnNull() {
        AppUser result = appUserService.getAppUserById("");
        assertNull(result);
    }
}