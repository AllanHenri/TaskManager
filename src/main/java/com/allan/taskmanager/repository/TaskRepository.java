package com.allan.taskmanager.repository;

import com.allan.taskmanager.domain.Task;
import com.allan.taskmanager.domain.TaskStatus;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
