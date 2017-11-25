module RestTimesSpec where

import Test.Hspec
import RestTimes


expect (h1, m1) (h2, m2) = calcRestTimes (Time h1 m1, Time h2 m2) restTerms
actual = (RestTimes . Times)


spec :: Spec
spec = do
  describe "定時が 09:00 - 18:00 で休憩が 12:00 - 13:00 と 20:00 - 21:00 の場合" $ do
    it "09:00 - 18:00 働くと  60 分の休憩" $
      expect (9, 0) (18, 0) `shouldBe` actual 60

    it "09:00 - 22:00 働くと 120 分の休憩" $
      expect (9, 0) (22, 0) `shouldBe` actual 120

    it "09:00 - 20:30 働くと  90 分の休憩" $
      expect (9, 0) (20, 30) `shouldBe` actual 90
