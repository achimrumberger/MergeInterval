package achim.uebungen.mergeinterval;

import java.util.*;

public class IntervalMerge
{   
	/*
	 *  Input: [25,30] [2,19] [14, 23] [4,8]  Output: [2,23] [25,30]
        https://www.youtube.com/watch?v=WdgAKCnWnwA
	 */

    public static ArrayList<Interval> mergeIntervallList(final List<Interval>  intervalsList) throws MalformedIntervallException {
    	
    	ArrayList<Interval> result = new ArrayList<Interval>();

        if(intervalsList.size() == 0 || intervalsList.size() == 1)
            return result;
        
        Collections.sort(intervalsList, new IntervalComparator());

        Interval first = intervalsList.get(0);
        int start = first.getStart();
        int end = first.getEnd();
       
        if(start > end) 
        	throw new MalformedIntervallException("hi");
        for (int i = 1; i < intervalsList.size(); i++) {
        	     	
            Interval current = intervalsList.get(i);
            if(current.getStart() > current.getEnd()) 
            	throw new MalformedIntervallException("hi");
            if (current.getStart() <= end) {
                end = Math.max(current.getEnd(), end);
            } else {
                result.add(new Interval(start, end));
                start = current.getStart();
                end = current.getEnd();
            }
        }

        result.add(new Interval(start, end));
        return result;
    }
}