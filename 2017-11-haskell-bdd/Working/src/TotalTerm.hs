module TotalTerm(
    TotalTerm(..),
    calcRestTimes,
    calcWorkingTimesInRegularTermDef,
    module Time,
    module RegularTermDef,
    module RestTermDef,
    module RestTimes,
    module WorkingTimes
) where

import Data.List(sort)

import Time
import RegularTermDef
import RestTermDef
import RestTimes
import WorkingTimes

data TotalTerm = TotalTerm Time Time deriving (Show, Eq)

calcRestTimes :: TotalTerm -> [RestTermDef] -> RestTimes
calcRestTimes totalTerm restTermDefs = foldl1 add restTimes
    where
        restTimes = map (\def -> f totalTerm def) restTermDefs

        f :: TotalTerm -> RestTermDef -> RestTimes
        f (TotalTerm t_ _t) (RestTermDef r_ _r)
            | r_ <= t_ && _t <= _r = RestTimes $ _t -? t_
            | r_ <= t_ && _r <= _t = RestTimes $ _r -? t_
            | _r <= t_             = RestTimes $ Times 0
            | _t <= r_             = RestTimes $ Times 0
            | t_ <= r_ && _t <= _r = RestTimes $ _t -? r_
            | t_ <= r_ && _t <= _r = RestTimes $ Times 0
            | t_ <= r_ && _r <= _t = RestTimes $ _r -? r_
            | _t <= r_             = RestTimes $ Times 0

calcWorkingTimesInRegularTermDef :: TotalTerm -> RegularTermDef -> [RestTermDef] -> WorkingTimesInRegularTermDef
calcWorkingTimesInRegularTermDef (TotalTerm t_ _t) (RegularTermDef r_ _r) restTermDefs = WorkingTimesInRegularTermDef (_r -? r_ +? (Times (-60))) -- oh...

calcWorkingTimesOutOfRegularTermDef :: TotalTerm -> RegularTermDef -> [RestTermDef] -> WorkingTimesOutOfRegularTermDef
calcWorkingTimesOutOfRegularTermDef = undefined -- zzz...
