import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers.not
import org.scalatest.matchers.should.Matchers.{equal, include, should, shouldEqual}

import java.io.{ByteArrayOutputStream, PrintStream}
import java.time.LocalDate
import java.util.UUID

class TaskManagerTests extends AnyFunSuite with BeforeAndAfterEach {

  test("Test Add Task") {
    val description = "Dummy Task"
    val dueDate = LocalDate.now()
    taskManager.addTask(description, dueDate)
    val result = taskManager.viewAllTasks()
    result should include(s"Task Description: ${description}")
    result should include(s"Due Date: ${dueDate}")
    result should include(s"Status: ${TaskStatus.Incomplete}")
  }

  test("View Task") {
    val testTask = Task(UUID.randomUUID(), "test", LocalDate.now(), TaskStatus.Complete)
    val actual = taskManager.viewTask(testTask)
    actual should include(s"Task Description: ${testTask.taskDescription}")
    actual should include(s"Due Date: ${testTask.dueDate}")
    actual should include(s"Status: ${testTask.status}")
  }

  test("View All Tasks") {
    taskManager.addTask("DummyTask1", LocalDate.now())
    taskManager.addTask("DummyTask2", LocalDate.now())
    val allTasks = taskManager.viewAllTasks()
    allTasks should include(s"Task Description: DummyTask1")
    allTasks should include(s"Task Description: DummyTask2")
  }

  test("Mark Complete") {
    val description = "Incomplete Task"
    val dueDate = LocalDate.now()
    val testTask = Task(UUID.randomUUID(), description, dueDate, TaskStatus.Incomplete)
    taskManager.markComplete(testTask)
    testTask.status should equal(TaskStatus.Complete)
  }

  test("Delete Task") {
    val testTask = Task(UUID.randomUUID(), "test task to be deleted", LocalDate.now(), TaskStatus.Incomplete)
    taskManager.addTask(testTask)
    var allTasks = taskManager.viewAllTasks()
    println(allTasks)
    allTasks should include(s"Task Description: ${testTask.taskDescription}")
    allTasks should include(s"Status: ${testTask.status}")
    taskManager.deleteTask(testTask)
    allTasks = taskManager.viewAllTasks()
    allTasks should not include(s"Task Description: ${testTask.taskDescription}")
    allTasks should not include(s"Status: ${testTask.status}")
  }
}
