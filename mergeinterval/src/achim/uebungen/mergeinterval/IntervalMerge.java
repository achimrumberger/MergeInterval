package achim.uebungen.mergeinterval;

import java.util.*;

public class IntervalMerge
{   

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
