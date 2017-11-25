module TimeSpec where

import Test.Hspec
import Time

spec :: Spec
spec = do
  describe "Time" $ do
    it "09:00 から 12:30 は 210 分" $
      (Time 12 30) -? (Time 9 0) `shouldBe` Times 210
  describe "Times" $ do
    it "60 分と 30 分で 90 分" $
      Times 60 ++? Times 30 `shouldBe` Times 90
