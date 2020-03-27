package domain.working_date

import java.time.LocalDate

case class WorkingDay(value: LocalDate) {
  def isIn(month: WorkingMonth): Boolean = {
    month.value.getYear == value.getYear && month.value.getMonthValue == value.getMonthValue
  }
}
