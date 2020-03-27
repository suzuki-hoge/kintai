package domain.break_hours

import domain.office_hours.{EndTime, StartTime}

case class OfficeMinutesWithoutBreaking(value: Int)

object OfficeMinutesWithoutBreaking {
  def of(start: StartTime, end: EndTime, breaks: Seq[BreakingMinutes]): OfficeMinutesWithoutBreaking = {
    OfficeMinutesWithoutBreaking(
      (end.h - start.h) * 60 + (end.m - start.m) - breaks.map(_.value).sum
    )
  }
}
