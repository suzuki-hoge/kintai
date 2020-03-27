package domain.office_hours

import org.scalatest.FunSuite

class WorkingHoursTest extends FunSuite {
  test("withoutBreaking") {
    val sut = WorkingHours(
      StartTime(9, 0),
      EndTime(17, 0)
    ).withoutBreaking()

    assert(sut.value == 420)
  }
}
