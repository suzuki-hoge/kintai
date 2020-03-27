package api.input

import java.time.LocalDate

import api.FormTester.{assertSuccess, assertFailure}
import domain.office_hours.{EndTime, StartTime}
import domain.working_date.WorkingDay
import org.scalatest.FunSuite

class InputOfficeHourRequestTest extends FunSuite {
  test("valid") {
    val sut = InputOfficeHourRequest.validate(Seq("-date:20170723", "-start:0900", "-end:1800"))

    assertSuccess(sut, InputOfficeHourRequest(WorkingDay(LocalDate.of(2017, 7, 23)), StartTime(9, 0), EndTime(18, 0)))
  }

  test("invalid") {
    val sut = InputOfficeHourRequest.validate(Seq("-stat:0900", "-end:"))

    assertFailure(sut, "no '-date' key on WorkingDayForm, no '-start' key on StartTimeForm, no '-end' key on EndTimeForm")
  }
}
