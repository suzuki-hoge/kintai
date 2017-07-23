package api.input.form

import java.time.LocalDate

import api.FormTester.{assertFailure, assertSuccess}
import domain.working_date.WorkingDay
import org.scalatest.FunSuite

class WorkingDayFormTest extends FunSuite {
  test("bind") {
    assertFailure(
      WorkingDayForm.bind(None), "no '-date' key on WorkingDayForm"
    )
    assertFailure(
      WorkingDayForm.bind(Some("")), "must not be empty on WorkingDayForm"
    )
    assertSuccess(
      WorkingDayForm.bind(Some("20170723")), WorkingDay(LocalDate.of(2017, 7, 23))
    )
  }
}
