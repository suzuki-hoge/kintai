module RestTerm where

import Time

data RestTerm = RestTerm Time Time deriving (Show, Eq)

restTerms = [RestTerm (Time 12 0) (Time 13 0), RestTerm (Time 20 0) (Time 21 0)]
