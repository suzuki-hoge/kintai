module WorkingRecord(
  WorkingRecord(..),
  mkRecord,
  module Ex
) where

import Time as Ex
import TotalTerm as Ex
import RestTerm as Ex
import WorkingTimesInRegularTerm as Ex
import WorkingTimesOutOfRegularTerm as Ex

data WorkingRecord = WorkingRecord {
    start        :: Time
  , end          :: Time
  , inRegular    :: Times
  , outOfRegular :: Times
  , worked       :: Times
  , rest         :: Times
  , total        :: Times
} deriving (Show, Eq)

mkRecord :: TotalTerm -> WorkingRecord
mkRecord tt = WorkingRecord start end inRegular outOfRegular worked rest total
    where
        (TotalTerm start end) = tt
        (WorkingTimesInRegularTerm inRegular) = calcWorkingTimesInRegularTerm tt regularTerm restTerms
        (WorkingTimesOutOfRegularTerm outOfRegular) = calcWorkingTimesOutOfRegularTerm tt regularTerm restTerms
        worked = inRegular ++? outOfRegular
        (RestTimes rest) = calcRestTimes (start, end) restTerms
        total = worked ++? rest
