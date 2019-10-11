package achim.uebungen.mergeinterval;

import java.util.Comparator;

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval i1, Interval i2)
    {
        return i1.getStart() - i2.getStart();
    }
}