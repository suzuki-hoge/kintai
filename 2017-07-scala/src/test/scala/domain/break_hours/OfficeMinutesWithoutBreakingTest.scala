package domain.break_hours

import domain.office_hours.{EndTime, StartTime}
import org.scalatest.FunSuite

class OfficeMinutesWithoutBreakingTest extends FunSuite {
  test("of") {
    val sut = OfficeMinutesWithoutBreaking.of(
      StartTime(9, 0),
      EndTime(18, 0),
      Seq(BreakingMinutes(60))
    )

    assert(sut.value == 480)
  }
}
