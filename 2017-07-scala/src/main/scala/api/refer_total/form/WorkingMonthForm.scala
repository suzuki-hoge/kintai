package api.refer_total.form

import api.FormUtils.{Validated, asLD, failure}
import domain.working_date.WorkingMonth

import scalaz.Scalaz._

object WorkingMonthForm {
  def bind(value: Option[String]): Validated[WorkingMonth] = value match {
    case None => failure("no '-date' key", "WorkingMonth")
    case Some("") => failure("must not be empty", "WorkingMonth")
    case Some(s) => WorkingMonth(asLD(s)).successNel
  }
}
