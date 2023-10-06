import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers.equal
import org.scalatest.matchers.should.Matchers.shouldEqual
import org.scalatest.matchers.should.Matchers.shouldNot

import java.time.LocalDate
import java.util.UUID

class TaskTests extends AnyFunSuite{
  test("Able to create a new task with status Incomplete") {
    val randomUUID = UUID.randomUUID()
    val description = "test task"
    val dueDate = LocalDate.now()
    val status = TaskStatus.Incomplete

    val testTask = Task(randomUUID, description, dueDate, status)
    testTask.taskId shouldEqual randomUUID
    testTask.taskDescription shouldEqual description
    testTask.dueDate shouldEqual dueDate
    testTask.status shouldEqual status
  }

  test("Able to create a new task with status Complete") {
    val randomUUID = UUID.randomUUID()
    val description = "test task"
    val dueDate = LocalDate.now()
    val status = TaskStatus.Complete

    val testTask = Task(randomUUID, description, dueDate, status)
    testTask.taskId shouldEqual randomUUID
    testTask.taskDescription shouldEqual description
    testTask.dueDate shouldEqual dueDate
    testTask.status shouldEqual status
  }

  test("Check two similar tasks evaluates to true on comparison") {
    val randomUUID = UUID.randomUUID()
    val description = "test task"
    val dueDate = LocalDate.now()
    val status = TaskStatus.Complete

    val testTask1 = Task(randomUUID, description, dueDate, status)
    val testTask2 = Task(randomUUID, description, dueDate, status)
    testTask1 shouldEqual testTask2
  }

  test("Check two different tasks evaluates to false on comparison") {
    val randomUUID = UUID.randomUUID()
    val description = "test task"
    val dueDate = LocalDate.now()
    val status = TaskStatus.Complete

    val testTask1 = Task(randomUUID, description, dueDate, status)
    val testTask2 = Task(randomUUID, description+"xxx", dueDate, status)
    testTask1 shouldNot equal(testTask2)
  }
}
