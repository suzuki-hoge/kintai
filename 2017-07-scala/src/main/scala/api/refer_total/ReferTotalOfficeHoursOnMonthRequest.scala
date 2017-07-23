package api.refer_total

import api.FormUtils.{Validated, asValue}
import api.refer_total.form.WorkingMonthForm
import domain.working_date.WorkingMonth

case class ReferTotalOfficeHoursOnMonthRequest(month: WorkingMonth)

object ReferTotalOfficeHoursOnMonthRequest {
  def validate(values: Seq[String]): Validated[ReferTotalOfficeHoursOnMonthRequest] = {
    val m: Option[String] = asValue(values, "-date:")

    WorkingMonthForm.bind(m).map(
      ReferTotalOfficeHoursOnMonthRequest(_)
    )
  }
}
