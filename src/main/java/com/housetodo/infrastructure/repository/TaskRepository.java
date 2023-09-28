package com.housetodo.infrastructure.repository;

import com.housetodo.infrastructure.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TaskRepository extends JpaRepository<Task, Serializable>, ITaskRepository {
}
