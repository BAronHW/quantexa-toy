package com.taskmanager.controller

import com.taskmanager.dto.*
import com.taskmanager.service.TaskService
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.*
import scala.jdk.CollectionConverters.*

@RestController
@RequestMapping(path = Array("/api/tasks"))
class TaskController(taskService: TaskService):

  @GetMapping
  def getAll(): java.util.List[TaskResponse] =
    taskService.getAllTasks()
      .map(TaskResponse.fromEntity)
      .asJava

  @GetMapping(path = Array("/{id}"))
  def getById(@PathVariable id: Long): ResponseEntity[TaskResponse] =
    taskService.getTaskById(id) match
      case Some(task) => ResponseEntity.ok(TaskResponse.fromEntity(task))
      case None => ResponseEntity.notFound().build()

  @PostMapping
  def create(@RequestBody request: CreateTaskRequest): ResponseEntity[TaskResponse] =
    val task = taskService.createTask(request.title, request.description)
    ResponseEntity
      .status(HttpStatus.CREATED)
      .body(TaskResponse.fromEntity(task))

  @PutMapping(path = Array("/{id}"))
  def update(
    @PathVariable id: Long,
    @RequestBody request: UpdateTaskRequest
  ): ResponseEntity[TaskResponse] =
    taskService.updateTask(id, request.title, request.description) match
      case Some(task) => ResponseEntity.ok(TaskResponse.fromEntity(task))
      case None => ResponseEntity.notFound().build()

  @PatchMapping(path = Array("/{id}/complete"))
  def complete(@PathVariable id: Long): ResponseEntity[?] =
    taskService.completeTask(id) match
      case Right(task) => ResponseEntity.ok(TaskResponse.fromEntity(task))
      case Left(error) => ResponseEntity.badRequest().body(ErrorResponse(error))

  @DeleteMapping(path = Array("/{id}"))
  def delete(@PathVariable id: Long): ResponseEntity[Void] =
    if taskService.deleteTask(id) then
      ResponseEntity.noContent().build()
    else
      ResponseEntity.notFound().build()

case class ErrorResponse(message: String)