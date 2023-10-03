package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Serializable>, ITaskRepository {
    List<Task> findByUserGroup(UserGroup userGroup);


    @Modifying
    @Transactional
    @Query("delete from Task t where t.taskId = ?1")
    int deleteByTaskId(int taskId);

    @Transactional
    @Query("select t from Task t where t.taskId = ?1")
    Task getById(int id);
}
