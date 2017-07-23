package domain.office_hours

import java.time.LocalDate

import domain.working_date.WorkingDay
import org.scalatest.FunSuite

class OfficeHoursFactoryTest extends FunSuite {
  test("no over") {
    val sut = OfficeHoursFactory.create(
      WorkingDay(LocalDate.of(2017, 7, 23)),
      StartTime(9, 0),
      EndTime(15, 0)
    )

    assert(sut.workingHours.start.h == 9)
    assert(sut.workingHours.start.m == 0)
    assert(sut.workingHours.end.h == 15)
    assert(sut.workingHours.end.m == 0)

    assert(sut.overHours.isEmpty)
  }

  test("has over") {
    val sut = OfficeHoursFactory.create(
      WorkingDay(LocalDate.of(2017, 7, 24)),
      StartTime(9, 30),
      EndTime(23, 45)
    )

    assert(sut.workingHours.start.h == 9)
    assert(sut.workingHours.start.m == 30)
    assert(sut.workingHours.end.h == 17)
    assert(sut.workingHours.end.m == 30)

    assert(sut.overHours.nonEmpty)
    assert(sut.overHours.get.start.h == 17)
    assert(sut.overHours.get.start.m == 30)
    assert(sut.overHours.get.end.h == 23)
    assert(sut.overHours.get.end.m == 45)
  }
}
