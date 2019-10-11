package achim.uebungen.mergeinterval;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class IntervalMergeTest {
	

	@Test
	public void goodTest() throws MalformedIntervallException {

		ArrayList<Interval> inputInterVal = new ArrayList<>();

		inputInterVal.add(new Interval(25, 30));
		inputInterVal.add(new Interval(2, 19));
		inputInterVal.add(new Interval(14, 23));
		inputInterVal.add(new Interval(4, 8));

		ArrayList<Interval> outputInterVal = IntervalMerge.mergeIntervallList(inputInterVal);
		assertEquals(2, outputInterVal.size());
	}

	@Test
	public void goodTestForZero() throws MalformedIntervallException {

		ArrayList<Interval> inputInterVal = new ArrayList<>();

		inputInterVal.add(new Interval(0, 30));
		inputInterVal.add(new Interval(2, 19));
		inputInterVal.add(new Interval(14, 23));
		inputInterVal.add(new Interval(4, 8));

		ArrayList<Interval> outputInterVal = IntervalMerge.mergeIntervallList(inputInterVal);
		assertEquals(1, outputInterVal.size());

	}
	
	@Test
	public void testForCommonBoundaries() throws MalformedIntervallException {

		ArrayList<Interval> inputInterVal = new ArrayList<>();

		inputInterVal.add(new Interval(25, 30));
		inputInterVal.add(new Interval(2, 19));
		inputInterVal.add(new Interval(14, 19));
		inputInterVal.add(new Interval(4, 8));

		ArrayList<Interval> outputInterVal = IntervalMerge.mergeIntervallList(inputInterVal);
		assertEquals(2, outputInterVal.size());

	}
	
	@Test
	public void testForEmptyList() throws MalformedIntervallException {

		ArrayList<Interval> inputInterVal = new ArrayList<>();

		ArrayList<Interval> outputInterVal = IntervalMerge.mergeIntervallList(inputInterVal);
		assertEquals(0, outputInterVal.size());

	}
	
	@Test(expected = MalformedIntervallException.class)
	public void testForMalformedIntervallException() throws MalformedIntervallException {

		ArrayList<Interval> inputInterVal = new ArrayList<>();
		inputInterVal.add(new Interval(25, -30));
		inputInterVal.add(new Interval(2, 19));
		inputInterVal.add(new Interval(14, 23));
		inputInterVal.add(new Interval(4, 8));

		ArrayList<Interval> outputInterVal = IntervalMerge.mergeIntervallList(inputInterVal);
		

	}
	
	

}
