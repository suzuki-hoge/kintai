package domain.office_hours

import java.time.LocalDate

import domain.working_date.WorkingDay
import org.scalatest.FunSuite

class OfficeHoursTest extends FunSuite {
  test("no over") {
    val sut = OfficeHours(
      WorkingDay(LocalDate.of(2017, 7, 23)),
      WorkingHours(StartTime(9, 0), EndTime(15, 0)),
      None
    )

    assert(sut.workingMinutes().value == 300)
    assert(sut.overMinutes().value == 0)
  }

  test("has over") {
    val sut = OfficeHours(
      WorkingDay(LocalDate.of(2017, 7, 24)),
      WorkingHours(StartTime(9, 0), EndTime(17, 0)),
      Option(OverHours(StartTime(17, 0), EndTime(23, 0)))
    )

    assert(sut.workingMinutes().value == 420)
    assert(sut.overMinutes().value == 240)
  }
}
