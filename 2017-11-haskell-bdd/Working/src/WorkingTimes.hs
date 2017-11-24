module WorkingTimes where

import Time

data WorkingTimesInRegularTermDef = WorkingTimesInRegularTermDef Times deriving (Show, Eq)

data WorkingTimesOutOfRegularTermDef = WorkingTimesOutOfRegularTermDef Times deriving (Show, Eq)
