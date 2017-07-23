package domain.office_hours

import domain.working_date.WorkingDay

object OfficeHoursFactory {
  def create(day: WorkingDay, start: StartTime, end: EndTime): OfficeHours = {
    val workingHours = WorkingHours(
      start, if (hasOver(start, end)) EndTime(start.h + 8, start.m) else end
    )
    val overHours = if (hasOver(start, end)) {
      Option(OverHours(StartTime(start.h + 8, start.m), end))
    } else {
      None
    }

    OfficeHours(day, workingHours, overHours)
  }

  private def hasOver(start: StartTime, end: EndTime): Boolean = $(end.h, end.m) - $(start.h, start.m) > $(8, 0)

  private def $(h: Int, m: Int): Int = h * 60 + m
}
