import java.time.LocalDate
import java.util.UUID

case class Task(taskId: UUID, taskDescription: String, dueDate: LocalDate, status: TaskStatus)

//@main def main() = {
//  // add a task
//  println(UUID.randomUUID())
//  println(LocalDate.now())
//  println(TaskStatus.Complete)
//  val wakeUpEarly = Task(UUID.randomUUID(), "Wake up early in the morning by 6:30 AM", LocalDate.now(), TaskStatus.Incomplete )
//  val wakeUpLate = Task(UUID.randomUUID(), "Wake up late in the morning by 10:30 AM", LocalDate.now(), TaskStatus.Incomplete )
//
//  println(wakeUpEarly)
//  println(wakeUpLate)
//  println(wakeUpLate == wakeUpEarly)
//}
