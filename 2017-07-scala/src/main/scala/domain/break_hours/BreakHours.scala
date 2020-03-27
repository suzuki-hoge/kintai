package domain.break_hours

import domain.office_hours.{EndTime, StartTime}

object BreakHours {
  val values: Seq[BreakHour] = Seq(
    BreakHour(BreakStartTime(12, 0), BreakEndTime(13, 0)),
    BreakHour(BreakStartTime(18, 0), BreakEndTime(19, 0)),
    BreakHour(BreakStartTime(21, 0), BreakEndTime(22, 0))
  )

  def withoutBreaking(start: StartTime, end: EndTime): OfficeMinutesWithoutBreaking = {
    OfficeMinutesWithoutBreaking.of(
      start,
      end,
      values.map(BreakingMinutes.of(start, end, _))
    )
  }
}
