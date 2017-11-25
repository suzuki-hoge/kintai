module WorkingTimesInRegularTermSpec where

import Test.Hspec
import WorkingTimesInRegularTerm


expect (h1, m1) (h2, m2) = calcWorkingTimesInRegularTerm tt regularTerm restTerms
    where
        tt = TotalTerm (Time h1 m1) (Time h2 m2)

actual = (WorkingTimesInRegularTerm . Times)


spec :: Spec
spec = do
  describe "定時が 09:00 - 18:00 で休憩が 12:00 - 13:00 と 20:00 - 21:00 の場合" $ do
    it "09:00 - 18:00 働くと 480 分の定時間内就業時間" $
      expect (9, 0) (18, 0) `shouldBe` actual 480

    it "07:00 - 22:00 働くと 480 分の定時間内就業時間" $
      expect (7, 0) (22, 0) `shouldBe` actual 480
