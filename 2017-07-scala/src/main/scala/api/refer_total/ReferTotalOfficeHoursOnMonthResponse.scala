package api.refer_total

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import api.ValidationError
import domain.office_hours.OfficeHoursOnMonth

case class ReferTotalOfficeHoursOnMonthResponse(map: Map[String, Any])

object ReferTotalOfficeHoursOnMonthResponse {
  def success(result: OfficeHoursOnMonth): ReferTotalOfficeHoursOnMonthResponse = {
    ReferTotalOfficeHoursOnMonthResponse(
      Map(
        "month" -> $(result.month.value),
        "days" -> result.values.map(
          it => Map(
            "day" -> $(it.day.value),
            "working_minutes" -> it.workingMinutes().value,
            "over_minutes" -> it.overMinutes().value
          )
        )
      )
    )
  }

  private def $(value: LocalDate): String = value.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

  def failure(result: List[ValidationError]): ReferTotalOfficeHoursOnMonthResponse = {
    ReferTotalOfficeHoursOnMonthResponse(
      Map(
        "validation_errors" -> result.map(_.toString)
      )
    )
  }
}
