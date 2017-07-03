package mma.legacy.interval.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalFactory;
import mma.legacy.interval.IntervalType;

public class IntervalsApiTest {
	private Interval bothOpenedPivot;
	private Interval leftOpenedPivot;
	private Interval rightOpenedPivot;
	private Interval unopenedOpenedPivot;
	private IntervalsApi intervalsApi;

	@Before
	public void setup() {
		this.bothOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.BOTH_OPENED);
		this.leftOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.LEFT_OPENED);
		this.rightOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.RIGHT_OPENED);
		this.unopenedOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.UNOPENED);
		intervalsApi=new IntervalsApi();
	}

	@Test
	public void getMidPointTest() {	
		
		Interval intervalBoth=IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED);
		assertThat(intervalsApi.calcutetMidPoint(intervalBoth), is(5d));
		
		Interval intervalUnopened=IntervalFactory.getInterval(-10, 10, IntervalType.UNOPENED);
		assertThat(intervalsApi.calcutetMidPoint(intervalUnopened), is(0d));
		
		
		Interval intervalLeft=IntervalFactory.getInterval(-15, -5, IntervalType.UNOPENED);
		assertThat(intervalsApi.calcutetMidPoint(intervalLeft), is(-10d));


		Interval intervalRight=IntervalFactory.getInterval(-15, 25, IntervalType.RIGHT_OPENED);
		assertThat(intervalsApi.calcutetMidPoint(intervalRight), is(5d));
	
	}

	@Test
	public void isWithinIntervalTest() {
		Interval bothInterval=IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED);
		Interval leftInterval=IntervalFactory.getInterval(0, 10, IntervalType.LEFT_OPENED);
		Interval unopenedInterval=IntervalFactory.getInterval(0, 10, IntervalType.UNOPENED);
		Interval rightInterval=IntervalFactory.getInterval(0, 10, IntervalType.RIGHT_OPENED);
		
		
		
		assertThat(intervalsApi.isValueWithinInterval(bothInterval, -3), is(false));
		assertThat(intervalsApi.isValueWithinInterval(leftInterval, -3), is(false));
		assertThat(intervalsApi.isValueWithinInterval(unopenedInterval, -3), is(false));
		assertThat(intervalsApi.isValueWithinInterval(rightInterval, -3), is(false));


		
		assertThat(intervalsApi.isValueWithinInterval(bothInterval, 0), is(false));
		assertThat(intervalsApi.isValueWithinInterval(leftInterval, 0), is(false));
		assertThat(intervalsApi.isValueWithinInterval(rightInterval, 0), is(true));
		assertThat(intervalsApi.isValueWithinInterval(unopenedInterval, 0), is(true));
		
		
		
		assertThat(intervalsApi.isValueWithinInterval(bothInterval, 5), is(true));
		assertThat(intervalsApi.isValueWithinInterval(leftInterval, 5), is(true));
		assertThat(intervalsApi.isValueWithinInterval(rightInterval, 5), is(true));
		assertThat(intervalsApi.isValueWithinInterval(unopenedInterval, 5), is(true));
		
		assertThat(intervalsApi.isValueWithinInterval(bothInterval, 10), is(false));
		assertThat(intervalsApi.isValueWithinInterval(leftInterval, 10), is(true));
		assertThat(intervalsApi.isValueWithinInterval(rightInterval, 10), is(false));
		assertThat(intervalsApi.isValueWithinInterval(unopenedInterval, 10), is(true));
		
		assertThat(intervalsApi.isValueWithinInterval(bothInterval, 13), is(false));
		assertThat(intervalsApi.isValueWithinInterval(leftInterval, 13), is(false));
		assertThat(intervalsApi.isValueWithinInterval(rightInterval, 13), is(false));
		assertThat(intervalsApi.isValueWithinInterval(unopenedInterval, 13), is(false));
	
	}


	@Test
	public void hasIntersectiontPivotTypeBothTest() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.BOTH_OPENED);
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)), is(false));
		
		
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)), is(false));
		
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)), is(false));
		
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(bothOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)), is(false));
	

	}

	@Test
	public void hasIntersectiontPivotTypeLeftTest() {
		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.LEFT_OPENED);
		
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)), is(false));
		
		
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)), is(false));
		
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)), is(false));
		
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(leftOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)), is(false));

    }
	
	
	@Test
	public void hasIntersectiontPivotTypeRightTest() {	
		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.RIGHT_OPENED);
		
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)), is(false));
	
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)), is(false));
		
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)), is(false));
		

		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(rightOpenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)), is(false));
		
	    }
	@Test
	public void hasIntersectiontPivotTypeUnopenedTest() {	
		Interval unopenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.UNOPENED);
//		
//		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)), is(false));
//		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)), is(false));
//		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)), is(true));
//		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)), is(true));
//		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)), is(true));
//		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)), is(true));
//		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)), is(false));

		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)), is(false));
		
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)), is(false));
	
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)), is(false));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)), is(true));
		assertThat(intervalsApi.intersectsWith(unopenedPivot, IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)), is(false));
	
	}

}
