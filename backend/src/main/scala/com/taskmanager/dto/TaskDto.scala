package com.taskmanager.dto

import com.taskmanager.domain.Task

case class CreateTaskRequest(title: String, description: String)

case class UpdateTaskRequest(title: Option[String], description: Option[String])

case class TaskResponse(id: Long, title: String, description: String, completed: Boolean)

object TaskResponse:
  def fromEntity(task: Task): TaskResponse =
    TaskResponse(task.id, task.title, task.description, task.completed)