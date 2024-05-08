class CommandLineInterface {
  private val entryMessage =
    s"""
       |Welcome to the Task Management System!
       |Please select an operation below:
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
def main() = {
  val cli = CommandLineInterface()
  cli.printEntryMessage()
  println(cli.getUserInput())
}