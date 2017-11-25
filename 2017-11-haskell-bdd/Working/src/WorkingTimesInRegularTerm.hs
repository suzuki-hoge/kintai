module WorkingTimesInRegularTerm (
  WorkingTimesInRegularTerm(..),
  calcWorkingTimesInRegularTerm,
  module Ex
) where

import Time as Ex
import TotalTerm as Ex
import RegularTerm as Ex
import RestTerm as Ex
import RestTimes as Ex

data WorkingTimesInRegularTerm = WorkingTimesInRegularTerm Times deriving (Show, Eq)

calcWorkingTimesInRegularTerm :: TotalTerm -> RegularTerm -> [RestTerm] -> WorkingTimesInRegularTerm
calcWorkingTimesInRegularTerm (TotalTerm t_ _t) (RegularTerm r_ _r) rts = WorkingTimesInRegularTerm $ (end -? start --? rest)
    where
        start = max r_ t_
        end = min _r _t
        (RestTimes rest) = calcRestTimes (start, end) rts
