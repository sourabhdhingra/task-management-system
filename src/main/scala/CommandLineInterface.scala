import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.util.control.Breaks.{break, breakable}

class CommandLineInterface {
  private val entryMessage =
    s"""
       |Welcome to the Task Management System!
       |Please select an operation below (Enter -1 to exit):
       |1. List all tasks
       |2. Add a new task
       |3. View an existing task
       |4. Mark a task complete
       |5. Delete an existing task
       |6. View tasks by status
       |""".stripMargin

  def getEntryMessage(): String = {
    entryMessage
    }

  def printEntryMessage(): Unit = {
    println(entryMessage)
  }

  def getUserInput(): Int = {
    val input = scala.io.StdIn.readInt()
    input
  }
}

@main
def main(): Unit = {
  val cli = CommandLineInterface()
  var count = 0
  // until -1 is entered loop would not exit
  breakable {
    while (true) {
      cli.printEntryMessage()
      cli.getUserInput() match
        case -1 => break
        case 1 => println(taskManager.viewAllTasks())
        case 2 =>
          println("Enter Task description")
          val description = scala.io.StdIn.readLine()
          println("Enter due date (dd/MM/yyyy)")
          val dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
          val dueDate = LocalDate.parse(scala.io.StdIn.readLine(), dateFormat)
          taskManager.addTask(description, dueDate)

      count = count + 1
    }
  }

}