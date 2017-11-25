module TotalWorkingRecordSpec where

import Test.Hspec
import TotalWorkingRecord


record (h1, m1) (h2, m2) = mkRecord tt
    where
        tt = TotalTerm (Time h1 m1) (Time h2 m2)

actual totalInRegular totalOutOfRegular totalWorked totalTotal = TotalWorkingRecord (Times totalInRegular) (Times totalOutOfRegular) (Times totalWorked) (Times totalTotal)

spec :: Spec
spec = do
  describe "定時が 09:00 - 18:00 で休憩が 12:00 - 13:00 と 20:00 - 21:00 の場合" $ do
    it "09:00 - 18:00 と 07:00 - 22:00 働くと総時間内 960 分, 総時間外 300 分, 総勤務計 1260 分, 総拘束 1440 分" $
      mkTotalRecord [record (9, 0) (18, 0), record (7, 0) (22, 0)] `shouldBe` actual 960 300 1260 1440
