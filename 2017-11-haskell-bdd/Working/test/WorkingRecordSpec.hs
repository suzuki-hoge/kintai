module WorkingRecordSpec where

import Test.Hspec
import WorkingRecord


expect (h1, m1) (h2, m2) = mkRecord tt
    where
        tt = TotalTerm (Time h1 m1) (Time h2 m2)

actual (h1, m1) (h2, m2) inRegular outOfRegular worked rest total = WorkingRecord (Time h1 m1) (Time h2 m2) (Times inRegular) (Times outOfRegular) (Times worked) (Times rest) (Times total)

spec :: Spec
spec = do
  describe "定時が 09:00 - 18:00 で休憩が 12:00 - 13:00 と 20:00 - 21:00 の場合" $ do
    it "09:00 - 18:00 働くと時間内 480 分, 時間外   0 分, 勤務計 480 分, 休憩  60 分, 拘束 540 分" $
      expect (9, 0) (18, 0) `shouldBe` actual (9, 0) (18, 0) 480 0 480 60 540

    it "07:00 - 22:00 働くと時間内 480 分, 時間外 300 分, 勤務計 780 分, 休憩 120 分, 拘束 900 分" $
      expect (7, 0) (22, 0) `shouldBe` actual (7, 0) (22, 0) 480 300 780 120 900
