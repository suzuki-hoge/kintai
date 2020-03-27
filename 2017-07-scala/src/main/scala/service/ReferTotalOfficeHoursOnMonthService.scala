package service

import domain.office_hours.OfficeHoursOnMonth
import domain.working_date.WorkingMonth

object ReferTotalOfficeHoursOnMonthService {
  def apply(month: WorkingMonth): OfficeHoursOnMonth = {
    null // repo.find(month)
  }
}
