package api.input

object InputOfficeHourApi {
  def apply(args: Seq[String]): Unit = {
    InputOfficeHourRequest.validate(args)
    // todo
  }
}
