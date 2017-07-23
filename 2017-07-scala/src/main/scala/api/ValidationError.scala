package api

case class ValidationError(message: String, form: String) {
  override def toString: String = message + " on " + form
}
