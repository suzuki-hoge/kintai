module WorkingTimesOutOfRegularTermSpec where

import Test.Hspec
import WorkingTimesOutOfRegularTerm


expect (h1, m1) (h2, m2) = calcWorkingTimesOutOfRegularTerm tt regularTerm restTerms
    where
        tt = TotalTerm (Time h1 m1) (Time h2 m2)

actual = (WorkingTimesOutOfRegularTerm . Times)


spec :: Spec
spec = do
  describe "定時が 09:00 - 18:00 で休憩が 12:00 - 13:00 と 20:00 - 21:00 の場合" $ do
    it "09:00 - 18:00 働くと   0 分の定時間外就業時間" $
      expect (9, 0) (18, 0) `shouldBe` actual 0

    it "09:00 - 20:00 働くと 120 分の定時間外就業時間" $
      expect (9, 0) (20, 0) `shouldBe` actual 120

    it "09:00 - 21:00 働くと 120 分の定時間外就業時間" $
      expect (9, 0) (21, 0) `shouldBe` actual 120

    it "07:00 - 22:00 働くと 300 分の定時間外就業時間" $
      expect (7, 0) (22, 0) `shouldBe` actual 300
