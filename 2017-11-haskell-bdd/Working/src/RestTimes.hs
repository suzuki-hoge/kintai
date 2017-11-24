module RestTimes where

import Time

data RestTimes = RestTimes Times deriving (Show, Eq)

add :: RestTimes -> RestTimes -> RestTimes
add (RestTimes t1) (RestTimes t2) = RestTimes $ t1 +? t2
