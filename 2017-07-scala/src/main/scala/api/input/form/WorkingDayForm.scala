package api.input.form

import api.FormUtils.{Validated, failure, asLD}
import domain.working_date.WorkingDay

import scalaz.Scalaz._

object WorkingDayForm {
  def bind(value: Option[String]): Validated[WorkingDay] = value match {
    case None => failure("no '-date' key", "WorkingDayForm")
    case Some("") => failure("must not be empty", "WorkingDayForm")
    case Some(s) => WorkingDay(asLD(s)).successNel
  }
}
