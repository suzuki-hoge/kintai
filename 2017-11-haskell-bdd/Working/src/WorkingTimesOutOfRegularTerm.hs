module WorkingTimesOutOfRegularTerm (
  WorkingTimesOutOfRegularTerm(..),
  calcWorkingTimesOutOfRegularTerm,
  module Ex
) where

import Time as Ex
import TotalTerm as Ex
import RegularTerm as Ex
import RestTerm as Ex
import RestTimes as Ex

data WorkingTimesOutOfRegularTerm = WorkingTimesOutOfRegularTerm Times deriving (Show, Eq)

calcWorkingTimesOutOfRegularTerm :: TotalTerm -> RegularTerm -> [RestTerm] -> WorkingTimesOutOfRegularTerm
calcWorkingTimesOutOfRegularTerm (TotalTerm t_ _t) (RegularTerm r_ _r) rts = WorkingTimesOutOfRegularTerm $ before ++? after
    where
        before = max (calc (t_, r_) rts) $ Times 0
        after = max (calc (_r, _t) rts) $ Times 0

type Term = (Time, Time)

calc :: Term -> [RestTerm] -> Times
calc (t_, _t) rts = _t -? t_ --? rest
    where
        (RestTimes rest) = calcRestTimes (t_, _t) rts

add :: WorkingTimesOutOfRegularTerm -> WorkingTimesOutOfRegularTerm -> WorkingTimesOutOfRegularTerm
add (WorkingTimesOutOfRegularTerm w1) (WorkingTimesOutOfRegularTerm w2) = WorkingTimesOutOfRegularTerm $ w1 ++? w2
