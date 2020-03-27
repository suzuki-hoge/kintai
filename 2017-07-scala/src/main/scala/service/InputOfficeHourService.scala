package service

import domain.office_hours.{EndTime, StartTime}
import domain.working_date.WorkingDay

object InputOfficeHourService {
  def apply(day: WorkingDay, start: StartTime, end: EndTime): Unit = {
    // repo.write(factory.create(...))
  }
}
