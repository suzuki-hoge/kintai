package api.refer_total

import java.time.LocalDate

import api.ValidationError
import domain.office_hours._
import domain.working_date.{WorkingDay, WorkingMonth}
import org.scalatest.FunSuite

class ReferTotalOfficeHoursOnMonthResponseTest extends FunSuite {
  test("success") {
    val sut = ReferTotalOfficeHoursOnMonthResponse.success(
      OfficeHoursOnMonth(
        WorkingMonth(LocalDate.of(2017, 7, 1)),
        Seq(
          OfficeHoursFactory.create(WorkingDay(LocalDate.of(2017, 7, 23)), StartTime(9, 0), EndTime(15, 0)),
          OfficeHoursFactory.create(WorkingDay(LocalDate.of(2017, 7, 24)), StartTime(9, 0), EndTime(23, 0)))
      )
    )

    val exp = Map(
      "month" -> "20170701",
      "days" -> Seq(
        Map(
          "day" -> "20170723",
          "working_minutes" -> 300,
          "over_minutes" -> 0
        ),
        Map(
          "day" -> "20170724",
          "working_minutes" -> 420,
          "over_minutes" -> 240
        )
      )
    )

    assert(sut.map == exp)
  }

  test("failure") {
    val sut = ReferTotalOfficeHoursOnMonthResponse.failure(
      List(
        ValidationError("foo", "FooForm"),
        ValidationError("bar", "BarForm")
      )
    )

    val exp = Map(
      "validation_errors" -> Seq(
        "foo on FooForm",
        "bar on BarForm"
      )
    )

    assert(sut.map == exp)
  }
}
