package api.refer_total

import service.ReferTotalOfficeHoursOnMonthService

import scalaz.Scalaz._

object ReferTotalOfficeHoursOnMonthApi {
  def apply(args: Seq[String]): ReferTotalOfficeHoursOnMonthResponse = {
    ReferTotalOfficeHoursOnMonthRequest.validate(args)
      .bimap(
        f => f.toList,
        req => ReferTotalOfficeHoursOnMonthService.apply(req.month)
      )
      .fold(
        ReferTotalOfficeHoursOnMonthResponse.failure,
        ReferTotalOfficeHoursOnMonthResponse.success
      )
  }
}
