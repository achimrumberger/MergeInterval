# MergeInterval
* interval are sorted first
* then check is made if following is either within the boundaries of the first interval, or if it overlapps.
* if the interval is completely within the boundaries of the first interval it is discarted, otherwise, the boundaries are adjusted.
* if the follwing intervall is completely disjunct of the first interval, the first interval is added to the result and we start again with following interval
* programm throws a MalformedIntervallException if the start point of the interval is greater than the endpoint


