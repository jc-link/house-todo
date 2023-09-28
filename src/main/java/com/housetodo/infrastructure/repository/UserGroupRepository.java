package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userGroupRepository")
public interface UserGroupRepository extends JpaRepository<UserGroup, Serializable>, IUserGroupRepository {

}
