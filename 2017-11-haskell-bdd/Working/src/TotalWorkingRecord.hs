module TotalWorkingRecord(
  TotalWorkingRecord(..),
  mkTotalRecord,
  module Ex
) where

import WorkingRecord as Ex

data TotalWorkingRecord = TotalWorkingRecord {
    totalInRegular    :: Times
  , totalOutOfRegular :: Times
  , totalWorked       :: Times
  , totalTotal        :: Times
} deriving (Show, Eq)

mkTotalRecord :: [WorkingRecord] -> TotalWorkingRecord
mkTotalRecord wrs = TotalWorkingRecord totalInRegular totalOutOfRegular totalWorked totalTotal
    where
        totalInRegular = foldl1 (++?) $ map inRegular wrs
        totalOutOfRegular = foldl1 (++?) $ map outOfRegular wrs
        totalWorked = foldl1 (++?) $ map worked wrs
        totalTotal = foldl1 (++?) $ map total wrs
