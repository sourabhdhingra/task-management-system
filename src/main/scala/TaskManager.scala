import java.time.LocalDate
import java.util.UUID


object taskManager {
  private var tasks: List[Task] = List()

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

  def viewAllTasks() = Nil
  def viewTaskByStatus() = Nil
  def markComplete() = Nil
  def deleteTask() = Nil
}

@main def main() = {
  taskManager.addTask("Wake up early", LocalDate.now())
}
