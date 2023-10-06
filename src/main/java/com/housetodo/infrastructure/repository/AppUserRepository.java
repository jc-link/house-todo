package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository("appUserRepository")
public interface AppUserRepository extends JpaRepository<AppUser, Serializable>, IAppUserRepository {

    @Query("select a from AppUser a where a.userId = ?1")
    AppUser findById(int id);

    @Modifying
    @Transactional
    @Query("delete from AppUser a where a.userId = ?1")
    int deleteByUserId(int userId);
}
