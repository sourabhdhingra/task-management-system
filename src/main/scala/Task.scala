import java.time.LocalDate
import java.util.UUID

case class Task(taskId: UUID, var taskDescription: String, var dueDate: LocalDate, var status: TaskStatus)
