package mma.legacy.interval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IntervalTest {
	private Interval bothOpenedPivot;
	private Interval leftOpenedPivot;
	private Interval rightOpenedPivot;
	private Interval unopenedOpenedPivot;

	@Before
	public void setup() {
		this.bothOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.BOTH_OPENED);
		this.leftOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.LEFT_OPENED);
		this.rightOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.RIGHT_OPENED);
		this.unopenedOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.UNOPENED);
	}

	@Test
	public void getMidPointTest() {
		assertEquals(5, IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED).getMidPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, IntervalType.LEFT_OPENED).getMidPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, IntervalType.RIGHT_OPENED).getMidPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, IntervalType.UNOPENED).getMidPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, IntervalType.BOTH_OPENED).getMidPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, IntervalType.LEFT_OPENED).getMidPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, IntervalType.RIGHT_OPENED).getMidPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, IntervalType.UNOPENED).getMidPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, IntervalType.BOTH_OPENED).getMidPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, IntervalType.LEFT_OPENED).getMidPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, IntervalType.RIGHT_OPENED).getMidPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, IntervalType.UNOPENED).getMidPoint(), 0.0);
	}

	@Test
	public void isWithinIntervalTest() {
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED).isWithinInterval(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.LEFT_OPENED).isWithinInterval(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.RIGHT_OPENED).isWithinInterval(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.UNOPENED).isWithinInterval(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED).isWithinInterval(0));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.LEFT_OPENED).isWithinInterval(0));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.RIGHT_OPENED).isWithinInterval(0));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.UNOPENED).isWithinInterval(0));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED).isWithinInterval(5));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.LEFT_OPENED).isWithinInterval(5));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.RIGHT_OPENED).isWithinInterval(5));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.UNOPENED).isWithinInterval(5));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED).isWithinInterval(10));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.LEFT_OPENED).isWithinInterval(10));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.RIGHT_OPENED).isWithinInterval(10));
		assertTrue(IntervalFactory.getInterval(0, 10, IntervalType.UNOPENED).isWithinInterval(10));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.BOTH_OPENED).isWithinInterval(13));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.LEFT_OPENED).isWithinInterval(13));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.RIGHT_OPENED).isWithinInterval(13));
		assertFalse(IntervalFactory.getInterval(0, 10, IntervalType.UNOPENED).isWithinInterval(13));
	}

	@Test
	public void isIncludedIntervalTypeBothTest() {

		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.BOTH_OPENED)));
	}

	@Test
	public void isIncludedIntervalTypeBothAndLeftTest() {

		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.LEFT_OPENED)));
	}

	@Test
	public void isIncludedIntervalTypeBothAndRightTest() {
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.RIGHT_OPENED)));
	}

	@Test
	public void isIncludedIntervalTypeBothAndUnopendTest() {
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.UNOPENED)));

	}

	@Test
	public void isIncludedIntervalTypeLeftBothTest() {

		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.BOTH_OPENED)));
	}

	@Test
	public void isIncludedIntervalTypeLeftTest() {
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.LEFT_OPENED)));
	}

	@Test
	public void isIncludedIntervalTypeLeftRightTest() {
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.RIGHT_OPENED)));
	}

	@Test
	public void isIncludedIntervalTypeLeftUopenedTest() {
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.UNOPENED)));

	}

	@Test
	public void isIncludedIntervalTypeRightBothTest() {

		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.BOTH_OPENED)));

	}

	@Test
	public void isIncludedIntervalTypeRightLeftTest() {

		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.LEFT_OPENED)));

	}

	@Test
	public void isIncludedIntervalTypeRightTest() {
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.RIGHT_OPENED)));

	}

	@Test
	public void isIncludedIntervalTypeRightUnopenedTest() {
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.UNOPENED)));

	}

	@Test
	public void isIncludedIntervalTypeUnopenedTest() {	
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.BOTH_OPENED)));
		
	}

	@Test
	public void isIncludedIntervalTypeUnopenedLeftTest() {
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.LEFT_OPENED)));
		
	}

	@Test
	public void isIncludedIntervalTypeUnopenedRightTest() {
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.RIGHT_OPENED)));
	}

	@Test
	public void isIncludedIntervalTypeUnopenedtTest() {
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(10, 15, IntervalType.UNOPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(15, 20, IntervalType.UNOPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(20, 25, IntervalType.UNOPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(25, 30, IntervalType.UNOPENED)));
		assertTrue(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(30, 35, IntervalType.UNOPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(35, 40, IntervalType.UNOPENED)));
		assertFalse(unopenedOpenedPivot.isIncludedInterval(IntervalFactory.getInterval(40, 45, IntervalType.UNOPENED)));

	}

	@Test
	public void hasIntersectionTest() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.BOTH_OPENED);

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));

		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.LEFT_OPENED);

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.RIGHT_OPENED);
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
		Interval unopenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.UNOPENED);
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
	}

	@Test
	public void hasIntersectionTest2() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.BOTH_OPENED);

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));

		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.LEFT_OPENED);

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.RIGHT_OPENED);
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
		Interval unopenedPivot = IntervalFactory.getInterval(20, 40, IntervalType.UNOPENED);
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, IntervalType.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, IntervalType.UNOPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, IntervalType.UNOPENED)));
	}

}
