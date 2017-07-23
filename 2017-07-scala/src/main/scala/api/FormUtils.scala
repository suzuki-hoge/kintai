package api

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import scalaz.Scalaz._
import scalaz.ValidationNel

object FormUtils {
  type Validated[S] = ValidationNel[ValidationError, S]

  def failure[S](message: String, form: String): Validated[S] = ValidationError(message, form).failureNel[S]

  def asH(value: String): Int = Integer.valueOf(value.substring(0, 2))

  def asM(value: String): Int = Integer.valueOf(value.substring(2, 4))

  def asLD(value: String): LocalDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"))

  def asValue(values: Seq[String], key: String): Option[String] = {
    values
      .find(_.startsWith(key))
      .filter(_ != key)
      .map(_.split(":")(1))
  }
}
