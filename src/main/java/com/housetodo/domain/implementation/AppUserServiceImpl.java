package com.housetodo.domain.implementation;

import com.housetodo.domain.service.AppUserService;
import com.housetodo.infrastructure.entity.AppUser;
import com.housetodo.infrastructure.entity.UserGroup;
import com.housetodo.infrastructure.repository.AppUserRepository;
import com.housetodo.infrastructure.repository.IAppUserRepository;
import com.housetodo.infrastructure.repository.IUserGroupRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appUserService")
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    @Qualifier("appUserRepository")
    private IAppUserRepository appUserRepository;

    @Autowired
    @Qualifier("userGroupRepository")
    private IUserGroupRepository userGroupRepository;

    private static final Logger logger = LogManager.getLogger();
    @Override
    public AppUser saveAppUser(AppUser appUser) {
        try {
            UserGroup userGroup = userGroupRepository.getById(appUser.getUserGroup().getUserGroupId());
            if (userGroup == null) {
                return null;
            }
            return appUserRepository.save(appUser);
        } catch (Exception e) {
            logger.warn("Error at saving user." + e);
            return null;
        }


    }

    @Override
    public AppUser getAppUserById(String userId) {
        try {
            return appUserRepository.findById(Integer.parseInt(userId));
        } catch (NumberFormatException e) {
            logger.warn("Error at parsing String to id " + e);
            return null;
        }
    }

    @Override
    public List<AppUser> getAppUserByUserGroup(UserGroup userGroup) {
        return appUserRepository.findByUserGroup(userGroup);
    }

    @Override
    public int deleteAppUser(String userId) {
        try {
            return appUserRepository.deleteByUserId(Integer.parseInt(userId));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public AppUser updateAppUser(AppUser appUser) {
        try {
            AppUser userExist = appUserRepository.findById(appUser.getUserId());
            if(userExist == null) {
                return null;
            }
            return appUserRepository.save(appUser);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
