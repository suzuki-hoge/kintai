package domain.working_date

import java.time.LocalDate

import org.scalatest.FunSuite

class WorkingDayTest extends FunSuite {
  test("isIn") {
    val m = WorkingMonth(LocalDate.of(2017, 7, 1))
    val d = WorkingDay(LocalDate.of(2017, 7, 23))

    assert(d.isIn(m))
  }

  test("!isIn") {
    val m = WorkingMonth(LocalDate.of(2017, 7, 1))
    val d = WorkingDay(LocalDate.of(2018, 7, 23))

    assert(!d.isIn(m))
  }
}
