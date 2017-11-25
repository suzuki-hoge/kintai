module RestTimes(
  RestTimes(..),
  calcRestTimes,
  module Ex
) where

import Time as Ex
import TotalTerm as Ex
import RestTerm as Ex

data RestTimes = RestTimes Times deriving (Show, Eq)

type Term = (Time, Time)

calcRestTimes :: Term -> [RestTerm] -> RestTimes
calcRestTimes term rts = foldl1 add $ map (calc term) rts

calc :: Term -> RestTerm -> RestTimes
calc (t_, _t) (RestTerm r_ _r) = RestTimes $ max (end -? start) zero
    where
        start = max t_ r_
        end = min _t _r
        zero = Times 0

add :: RestTimes -> RestTimes -> RestTimes
add (RestTimes rt1) (RestTimes rt2) = RestTimes $ rt1 ++? rt2
