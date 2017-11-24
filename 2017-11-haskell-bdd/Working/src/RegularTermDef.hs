module RegularTermDef where

import Time

data RegularTermDef = RegularTermDef Time Time deriving (Show, Eq)

regularTermDef = RegularTermDef (Time "09:00") (Time "18:00")
