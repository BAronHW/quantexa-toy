package com.taskmanager.repository

import com.taskmanager.domain.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait TaskRepository extends JpaRepository[Task, java.lang.Long]