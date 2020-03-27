package domain.office_hours

import domain.break_hours.OfficeMinutesWithoutBreaking
import domain.working_date.WorkingDay

case class OfficeHours(day: WorkingDay, workingHours: WorkingHours, overHours: Option[OverHours]) {
  def workingMinutes(): OfficeMinutesWithoutBreaking = workingHours.withoutBreaking()

  def overMinutes(): OfficeMinutesWithoutBreaking = overHours.map(_.withoutBreaking()).getOrElse(OfficeMinutesWithoutBreaking(0))
}
