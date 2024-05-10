import java.time.LocalDate
import java.util.UUID
import scala.collection.mutable.ListBuffer


object taskManager {
  private var tasks: ListBuffer[Task] = ListBuffer()

  def addTask(description: String, dueDate: LocalDate): Unit = {
    tasks = tasks :+ Task(UUID.randomUUID(), description, dueDate, TaskStatus.Incomplete)
  }

  def addTask(task: Task): Unit = {
    tasks = tasks :+ task
  }

  def viewTask(task: Task): String = {
    val taskPrint =
      s"""
        |Task Description: ${task.taskDescription}
        |Due Date: ${task.dueDate}
        |Status: ${task.status}
        |""".stripMargin
    return taskPrint
  }

  def viewTaskByDescription(descriptionText: String) = {
    val filteredTasks = new StringBuilder("")
    tasks.filter(task => task.taskDescription.contains(descriptionText))
      .foreach(task => filteredTasks.append(viewTask(task) + "\n"))
    filteredTasks
  }

  def viewAllTasks(): String = {
    val allTasks = new StringBuilder("")
    tasks.foreach((task) => allTasks.append(viewTask(task) + "\n"))
    allTasks.toString()
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

//@main def main() = {
////  val testTask = Task(UUID.randomUUID(), "description", LocalDate.now(), TaskStatus.Incomplete)
////  taskManager.addTask(testTask)
////  println(taskManager.viewAllTasks())
////  taskManager.deleteTask(testTask)
////  println(taskManager.viewAllTasks())
////  taskManager.addTask("Wake up early", LocalDate.now())
////  taskManager.addTask("Wake up late", LocalDate.now())
////  println(taskManager.viewTask(testTask))
////  println(taskManager.viewAllTasks())
////  println("-------------------")
////  taskManager.viewTaskByStatus(TaskStatus.Incomplete)
////  println("-------------------")
////  taskManager.markComplete(testTask)
////  taskManager.viewTask(testTask)
//}
