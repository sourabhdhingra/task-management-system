import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

class CommandLineInterfaceTests extends AnyFunSuite{
  test("Able to print CLI entry message") {
    val entryMessage = CommandLineInterface().getEntryMessage()
    entryMessage shouldEqual
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
  }

  test("Able to take user input in Int") {
    val input: Int = 5
    val mockInput = new ByteArrayInputStream(input.toString.getBytes)
    var result:Int = 0
    Console.withIn(mockInput) {
      result = CommandLineInterface().getUserInput()
    }
    result shouldEqual input
  }
}
