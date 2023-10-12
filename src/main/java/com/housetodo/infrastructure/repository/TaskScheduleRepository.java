package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.Task;
import com.housetodo.infrastructure.entity.TaskSchedule;
import com.housetodo.infrastructure.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository("taskScheduleRepository")
public interface TaskScheduleRepository extends JpaRepository<TaskSchedule, Serializable>, ITaskScheduleRepository {

    List<TaskSchedule> findByTask(Task task);

    @Modifying
    @Transactional
    @Query("delete from TaskSchedule t where taskScheduleId = ?1")
    int deleteById(int taskScheduleId);

    @Transactional
    @Query("select t from TaskSchedule t where t.taskScheduleId = ?1")
    TaskSchedule getById(int taskScheduleId);
}
