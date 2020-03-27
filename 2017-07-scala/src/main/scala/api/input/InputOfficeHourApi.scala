package api.input

import service.InputOfficeHourService

object InputOfficeHourApi {
  def apply(args: Seq[String]): Unit = {
    InputOfficeHourRequest.validate(args)
      .map(req => InputOfficeHourService.apply(req.day, req.start, req.end))

    // 本当は Unit じゃあなくてバリデエラーは返すべきだけど、参照の方に包含する
  }
}
