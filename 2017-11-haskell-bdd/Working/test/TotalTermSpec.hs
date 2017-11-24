module TotalTermSpec where

import Test.Hspec
import TotalTerm
import Time

rest t_ _t rs = calcRestTimes (TotalTerm (Time t_) (Time _t)) restTermDefs
    where
        restTermDefs = (map (\(x, y) -> RestTermDef (Time x) (Time y)) rs)

inRegular t_ _t r_ _r = calcWorkingTimesInRegularTermDef (TotalTerm (Time t_) (Time _t)) (RegularTermDef (Time r_) (Time _r)) restTermDefs

spec :: Spec
spec = do
    describe "休憩が 12:00 - 13:00 の場合" $ do
        it "09:00 - 12:00 働くと  0 分の休憩" $
            rest "09:00" "12:00" [("12:00", "13:00")] `shouldBe` (RestTimes . Times) 0
        it "09:00 - 12:30 働くと 30 分の休憩" $
            rest "09:00" "12:30" [("12:00", "13:00")] `shouldBe` (RestTimes . Times) 30
        it "12:30 - 12:45 働くと 15 分の休憩" $
            rest "12:30" "12:45" [("12:00", "13:00")] `shouldBe` (RestTimes . Times) 15
        it "12:30 - 15:00 働くと 30 分の休憩" $
            rest "12:30" "15:00" [("12:00", "13:00")] `shouldBe` (RestTimes . Times) 30
        it "13:00 - 15:00 働くと  0 分の休憩" $
            rest "13:00" "15:00" [("12:00", "13:00")] `shouldBe` (RestTimes . Times) 0
        it "12:00 - 13:00 働くと 60 分の休憩" $
            rest "12:00" "13:00" [("12:00", "13:00")] `shouldBe` (RestTimes . Times) 60
        it "09:00 - 15:00 働くと 60 分の休憩" $
            rest "09:00" "15:00" [("12:00", "13:00")] `shouldBe` (RestTimes . Times) 60

    describe "休憩が 12:00 - 13:00 と 20:00 - 21:00 の場合" $ do
        it "09:00 - 18:00 働くと 60 分の休憩" $
            rest "09:00" "18:00" [("12:00", "13:00"), ("20:00", "21:00")] `shouldBe` (RestTimes . Times) 60
        it "09:00 - 20:00 働くと 60 分の休憩" $
            rest "09:00" "20:00" [("12:00", "13:00"), ("20:00", "21:00")] `shouldBe` (RestTimes . Times) 60
        it "09:00 - 20:30 働くと 90 分の休憩" $
            rest "09:00" "20:30" [("12:00", "13:00"), ("20:00", "21:00")] `shouldBe` (RestTimes . Times) 90
        it "13:00 - 22:00 働くと 60 分の休憩" $
            rest "13:00" "22:00" [("12:00", "13:00"), ("20:00", "21:00")] `shouldBe` (RestTimes . Times) 60

    describe "定時間が 09:00 - 18:00 の場合" $ do
        it "09:00 - 18:00 働くと 480 分の時間内就業時間" $
            inRegular "09:00" "18:00" "09:00" "18:00" `shouldBe` (WorkingTimesInRegularTermDef . Times) 480
