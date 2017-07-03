package mma.legacy.interval.include.interval.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalFactory;
import mma.legacy.interval.IntervalType;
import mma.legacy.interval.api.include.interval.validator.IncludedIntervalValidatorStrategy;
import mma.legacy.interval.api.include.interval.validator.IncludedIntervaltypeLeftValidator;

public class IncludedIntervaltypeLeftValidatorTest {
	
	private IncludedIntervalValidatorStrategy leftValidator;
	private Interval leftOpenedPivot;
	@Before
	public void setup() {
		this.leftOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.LEFT_OPENED);
		leftValidator=new IncludedIntervaltypeLeftValidator();
	}
	
	@Test
	public void isIncludedIntervalTypeLeftBothTest() {

		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.BOTH_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.BOTH_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.BOTH_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(25, 30, IntervalType.BOTH_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(30, 35, IntervalType.BOTH_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.BOTH_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.BOTH_OPENED)));
		
	}
	
	@Test
	public void isIncludedIntervalTypeLeftTest() {

		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.LEFT_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.LEFT_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.LEFT_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(25, 30, IntervalType.LEFT_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(30, 35, IntervalType.LEFT_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.LEFT_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.LEFT_OPENED)));
		
	}
	
	@Test
	public void isIncludedIntervalTypeLeftRightTest() {

		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.RIGHT_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(25, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(30, 35, IntervalType.RIGHT_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.RIGHT_OPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.RIGHT_OPENED)));
		
	}

	@Test
	public void isIncludedIntervalTypeLeftUopenedTest() {

		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.UNOPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.UNOPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.UNOPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(25, 30, IntervalType.UNOPENED)));
		assertTrue(leftValidator.validator(leftOpenedPivot,IntervalFactory.getInterval(30, 35, IntervalType.UNOPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.UNOPENED)));
		assertFalse(leftValidator.validator(leftOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.UNOPENED)));
		
	}




}
