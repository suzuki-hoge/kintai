module Time where

data Time = Time String deriving (Show, Eq)

instance Ord Time where
       compare (Time x) (Time y) = compare x y

data Times = Times Int deriving (Show, Eq)

(-?) :: Time -> Time -> Times
(-?) t1 t2 = Times (toM t1 - toM t2)
    where
        toM :: Time -> Int
        toM time = (h time) * 60 + m time
            where
                h :: Time -> Int
                h (Time v) = read $ takeWhile (/= ':') v
                m :: Time -> Int
                m (Time v) = read $ tail $ dropWhile (/= ':') v

(+?) :: Times -> Times -> Times
(+?) (Times x) (Times y) = Times $ x + y
