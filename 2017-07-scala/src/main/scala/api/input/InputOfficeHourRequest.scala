package api.input

import api.FormUtils.{Validated, asValue}
import api.input.form.{EndTimeForm, StartTimeForm, WorkingDayForm}
import domain.office_hours.{EndTime, StartTime}
import domain.working_date.WorkingDay

import scalaz.Scalaz._

case class InputOfficeHourRequest(day: WorkingDay, start: StartTime, end: EndTime)

object InputOfficeHourRequest {
  def validate(values: Seq[String]): Validated[InputOfficeHourRequest] = {
    val w: Option[String] = asValue(values, "-date:")
    val s: Option[String] = asValue(values, "-start:")
    val e: Option[String] = asValue(values, "-end:")

    (WorkingDayForm.bind(w) |@| StartTimeForm.bind(s) |@| EndTimeForm.bind(e))(
      (_w, _s, _e) => InputOfficeHourRequest(_w, _s, _e)
    )
  }
}
