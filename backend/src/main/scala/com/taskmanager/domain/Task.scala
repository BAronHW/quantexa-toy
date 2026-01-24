package com.taskmanager.domain
import jakarta.persistence.*

@Entity
@Table(name = "tasks")
class Task:

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = _

  var title: String = _

  var description: String = _

  var completed: Boolean = false

object Task:
  def apply(title: String, description: String): Task =
    val task = new Task()
    task.title = title
    task.description = description
    task