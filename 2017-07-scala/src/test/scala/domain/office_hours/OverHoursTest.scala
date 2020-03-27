package domain.office_hours

import org.scalatest.FunSuite

class OverHoursTest extends FunSuite {
  test("withoutBreaking") {
    val sut = OverHours(
      StartTime(17, 0),
      EndTime(23, 0)
    ).withoutBreaking()

    assert(sut.value == 240)
  }
}
