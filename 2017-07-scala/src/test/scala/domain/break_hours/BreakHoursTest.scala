package domain.break_hours

import domain.office_hours.{EndTime, StartTime}
import org.scalatest.FunSuite

class BreakHoursTest extends FunSuite {
  test("withoutBreaking") {
    val sut = BreakHours.withoutBreaking(
      StartTime(9, 0),
      EndTime(21, 30)
    )

    assert(sut.value == 600)
  }
}
