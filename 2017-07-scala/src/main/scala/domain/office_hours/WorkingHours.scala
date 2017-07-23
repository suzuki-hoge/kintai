package domain.office_hours

import domain.break_hours.{BreakHours, OfficeMinutesWithoutBreaking}

case class WorkingHours(start: StartTime, end: EndTime) {
  def withoutBreaking(): OfficeMinutesWithoutBreaking = {
    BreakHours.withoutBreaking(start, end)
  }
}
