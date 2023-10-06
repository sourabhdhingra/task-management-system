import java.time.LocalDate
import java.util.UUID
import scala.collection.mutable.ListBuffer


object taskManager {
  private var tasks: ListBuffer[Task] = ListBuffer()

  def addTask(description: String, dueDate: LocalDate): Unit = {
    tasks = tasks :+ Task(UUID.randomUUID(), description, dueDate, TaskStatus.Incomplete)
  }

  def viewTask(task: Task) = {
    val taskPrint =
      s"""
        |Task Description: ${task.taskDescription}
        |Due Date: ${task.dueDate}
        |Status: ${task.status}
        |""".stripMargin
    println(taskPrint)
  }

  def viewAllTasks() = {
    tasks.foreach(viewTask)
  }
  def viewTaskByStatus(status: TaskStatus) = {
    val tasksByStatus = tasks.filter(task => task.status == status)
    tasksByStatus.foreach(viewTask)
  }
  def markComplete(task: Task) = {
    task.status = TaskStatus.Complete
  }
  def deleteTask(task: Task) = {
    tasks -= task
  }
}

@main def main() = {
  val testTask = Task(UUID.randomUUID(), "description", LocalDate.now(), TaskStatus.Incomplete)
  taskManager.addTask("Wake up early", LocalDate.now())
  taskManager.addTask("Wake up late", LocalDate.now())
  taskManager.viewTask(testTask)
  taskManager.viewAllTasks()
  println("-------------------")
  taskManager.viewTaskByStatus(TaskStatus.Incomplete)
  println("-------------------")
  taskManager.markComplete(testTask)
  taskManager.viewTask(testTask)
}
