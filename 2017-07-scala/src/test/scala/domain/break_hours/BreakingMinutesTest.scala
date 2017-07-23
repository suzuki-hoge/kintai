package domain.break_hours

import domain.office_hours.{EndTime, StartTime}
import org.scalatest.FunSuite

class BreakingMinutesTest extends FunSuite {
  test("in") {
    val sut = BreakingMinutes.of(
      StartTime(9, 0),
      EndTime(18, 0),
      BreakHour(BreakStartTime(12, 0), BreakEndTime(13, 0))
    )

    assert(sut.value == 60)
  }

  test("not in") {
    val sut = BreakingMinutes.of(
      StartTime(9, 0),
      EndTime(18, 0),
      BreakHour(BreakStartTime(18, 0), BreakEndTime(19, 0))
    )

    assert(sut.value == 0)
  }

  test("head") {
    val sut = BreakingMinutes.of(
      StartTime(12, 15),
      EndTime(18, 0),
      BreakHour(BreakStartTime(12, 0), BreakEndTime(13, 0))
    )

    assert(sut.value == 45)
  }

  test("tail") {
    val sut = BreakingMinutes.of(
      StartTime(9, 0),
      EndTime(12, 15),
      BreakHour(BreakStartTime(12, 0), BreakEndTime(13, 0))
    )

    assert(sut.value == 15)
  }

  test("too over") {
    val sut = BreakingMinutes.of(
      StartTime(9, 0),
      EndTime(18, 0),
      BreakHour(BreakStartTime(21, 0), BreakEndTime(22, 0))
    )

    assert(sut.value == 0)
  }
}
