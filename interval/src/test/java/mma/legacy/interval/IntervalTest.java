package mma.legacy.interval;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class IntervalTest {
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
		
		
		
		assertThat(intervalsApi.isWithinInterval(bothInterval, -3), is(false));
		assertThat(intervalsApi.isWithinInterval(leftInterval, -3), is(false));
		assertThat(intervalsApi.isWithinInterval(unopenedInterval, -3), is(false));
		assertThat(intervalsApi.isWithinInterval(rightInterval, -3), is(false));


		
		assertThat(intervalsApi.isWithinInterval(bothInterval, 0), is(false));
		assertThat(intervalsApi.isWithinInterval(leftInterval, 0), is(false));
		assertThat(intervalsApi.isWithinInterval(rightInterval, 0), is(true));
		assertThat(intervalsApi.isWithinInterval(unopenedInterval, 0), is(true));
		
		
		
		assertThat(intervalsApi.isWithinInterval(bothInterval, 5), is(true));
		assertThat(intervalsApi.isWithinInterval(leftInterval, 5), is(true));
		assertThat(intervalsApi.isWithinInterval(rightInterval, 5), is(true));
		assertThat(intervalsApi.isWithinInterval(unopenedInterval, 5), is(true));
		
		assertThat(intervalsApi.isWithinInterval(bothInterval, 10), is(false));
		assertThat(intervalsApi.isWithinInterval(leftInterval, 10), is(true));
		assertThat(intervalsApi.isWithinInterval(rightInterval, 10), is(false));
		assertThat(intervalsApi.isWithinInterval(unopenedInterval, 10), is(true));
		
		assertThat(intervalsApi.isWithinInterval(bothInterval, 13), is(false));
		assertThat(intervalsApi.isWithinInterval(leftInterval, 13), is(false));
		assertThat(intervalsApi.isWithinInterval(rightInterval, 13), is(false));
		assertThat(intervalsApi.isWithinInterval(unopenedInterval, 13), is(false));
	
	}


//	@Test
//	public void hasIntersectionTest() {
//
//		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.BOTH_OPENED);
//
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//
//		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.LEFT_OPENED);
//
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.RIGHT_OPENED);
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//		Interval unopenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.UNOPENED);
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//	}
//
//	@Test
//	public void hasIntersectionTest2() {
//
//		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.BOTH_OPENED);
//
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//
//		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.LEFT_OPENED);
//
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.RIGHT_OPENED);
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//		Interval unopenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.UNOPENED);
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
//		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
//	}

}
