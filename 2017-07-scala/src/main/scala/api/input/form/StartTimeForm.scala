package api.input.form

import api.FormUtils.{Validated, asH, asM, failure}
import domain.office_hours.StartTime

import scalaz.Scalaz._

object StartTimeForm {
  def bind(value: Option[String]): Validated[StartTime] = value match {
    case None => failure("no '-start' key", "StartTimeForm")
    case Some("") => failure("must not be empty", "StartTimeForm")
    case Some(s) => StartTime(asH(s), asM(s)).successNel
  }
}
