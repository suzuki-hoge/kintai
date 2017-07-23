package api

import api.FormUtils.Validated

import scalaz.Scalaz._

object FormTester {
  def assertFailure[S](validated: Validated[S], exp: String): Unit = {
    assert(validated.fold(f => f.toList.mkString(", "), s => s) == exp)
  }

  def assertSuccess[S](validated: Validated[S], exp: S): Unit = {
    assert(validated.fold(f => "", s => s) == exp)
  }
}
