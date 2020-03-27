package api.input.form

import api.FormUtils.{Validated, asH, asM, failure}
import domain.office_hours.EndTime

import scalaz.Scalaz._

object EndTimeForm {
  def bind(value: Option[String]): Validated[EndTime] = value match {
    case None => failure("no '-end' key", "EndTimeForm")
    case Some("") => failure("must not be empty", "EndTimeForm")
    case Some(s) => EndTime(asH(s), asM(s)).successNel
  }
}
