module RegularTerm where

import Time

data RegularTerm = RegularTerm Time Time deriving (Show, Eq)

regularTerm = RegularTerm (Time 9 0) (Time 18 0)
