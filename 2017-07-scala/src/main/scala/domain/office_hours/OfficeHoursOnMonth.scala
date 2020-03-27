package domain.office_hours

import domain.working_date.WorkingMonth

case class OfficeHoursOnMonth(month: WorkingMonth, values: Seq[OfficeHours])
