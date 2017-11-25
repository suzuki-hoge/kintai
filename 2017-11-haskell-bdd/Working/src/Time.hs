module Time where

-- time
data Time = Time Int Int deriving (Show, Eq, Ord)

(-?) :: Time -> Time -> Times
(-?) (Time h1 m1) (Time h2 m2) = Times $ (h1 * 60 + m1) - (h2 * 60 + m2)

-- times
data Times = Times Int deriving (Show, Eq, Ord)

(++?) :: Times -> Times -> Times
(++?) (Times v1) (Times v2) = Times $ v1 + v2

(--?) :: Times -> Times -> Times
(--?) (Times v1) (Times v2) = Times $ v1 - v2
