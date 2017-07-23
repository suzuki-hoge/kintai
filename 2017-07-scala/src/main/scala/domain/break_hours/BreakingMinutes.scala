package domain.break_hours

import domain.office_hours.{EndTime, StartTime}

import scala.math.{max, min}

case class BreakingMinutes(value: Int)

object BreakingMinutes {
  def of(start: StartTime, end: EndTime, break: BreakHour): BreakingMinutes = {
    BreakingMinutes(
      max(
        min($(end.h, end.m), $(break.end.h, break.end.m)) - max($(start.h, start.m), $(break.start.h, break.start.m)), 0
      )
    )
  }

  private def $(h: Int, m: Int): Int = h * 60 + m
}
