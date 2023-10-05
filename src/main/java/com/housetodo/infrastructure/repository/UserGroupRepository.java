package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository("userGroupRepository")
public interface UserGroupRepository extends JpaRepository<UserGroup, Serializable>, IUserGroupRepository {
    @Modifying
    @Transactional
    @Query("delete from UserGroup u where u.userGroupId = ?1")
    int deleteById(int userGroupId);

    @Query("select u from UserGroup u where u.code = ?1")
    UserGroup getByCode(String code);

    @Query("select u from UserGroup u where u.userGroupId = ?1")
    UserGroup getById(int userGroupId);
}
