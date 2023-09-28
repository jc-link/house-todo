package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.TaskSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TaskScheduleRepository extends JpaRepository<TaskSchedule, Serializable>, ITaskRepository {
}
