package com.taskmanager.service

import com.taskmanager.domain.Task
import com.taskmanager.repository.TaskRepository
import org.springframework.stereotype.Service
import scala.jdk.CollectionConverters.*
import scala.jdk.OptionConverters.*

@Service
class TaskService(taskRepository: TaskRepository):

  def getAllTasks(): List[Task] =
    taskRepository.findAll().asScala.toList

  def getTaskById(id: Long): Option[Task] =
    taskRepository.findById(id).toScala

  def createTask(title: String, description: String): Task =
    val task = Task(title, description)
    taskRepository.save(task)

  def updateTask(id: Long, title: Option[String], description: Option[String]): Option[Task] =
    getTaskById(id).map { task =>
      title.foreach(t => task.title = t)
      description.foreach(d => task.description = d)
      taskRepository.save(task)
    }

  def completeTask(id: Long): Either[String, Task] =
    getTaskById(id) match
      case Some(task) if task.completed =>
        Left("Task already completed")
      case Some(task) =>
        task.completed = true
        Right(taskRepository.save(task))
      case None =>
        Left("Task not found")

  def deleteTask(id: Long): Boolean =
    if taskRepository.existsById(id) then
      taskRepository.deleteById(id)
      true
    else
      false