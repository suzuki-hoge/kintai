module RestTermDef where

import Time

data RestTermDef = RestTermDef Time Time deriving (Show, Eq)

restTermDefs = [RestTermDef (Time "12:00") (Time "13:00"), RestTermDef (Time "20:00") (Time "21:00")]
