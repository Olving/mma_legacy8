package mma.legacy.interval.include.interval.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalFactory;
import mma.legacy.interval.IntervalType;
import mma.legacy.interval.api.include.interval.validator.IncludedIntervalValidatorStrategy;
import mma.legacy.interval.api.include.interval.validator.IncludedIntervaltypeBothValidator;

public class IncludedIntervaltypeBothValidatorTest {
	private Interval bothOpenedPivot;

	private IncludedIntervalValidatorStrategy bothValidator;

	@Before
	public void setup() {
		this.bothOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.BOTH_OPENED);
		bothValidator=new IncludedIntervaltypeBothValidator();
	}
	
	
	@Test
	public void isIncludedIntervalTypeBothTest() {

		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.BOTH_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.BOTH_OPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.BOTH_OPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(25, 30, IntervalType.BOTH_OPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(30, 35, IntervalType.BOTH_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.BOTH_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.BOTH_OPENED)));
		
	}
	
	@Test
	public void isIncludedIntervalTypeBothAndLeftTest() {
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.LEFT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.LEFT_OPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.LEFT_OPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(25, 30, IntervalType.LEFT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(30, 35, IntervalType.LEFT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.LEFT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.LEFT_OPENED)));
		
	}
	
	@Test
	public void isIncludedIntervalTypeBothAndRightTest() {
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.RIGHT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.RIGHT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.RIGHT_OPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(25, 30, IntervalType.RIGHT_OPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(30, 35, IntervalType.RIGHT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.RIGHT_OPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.RIGHT_OPENED)));
		
	}

	
	@Test
	public void isIncludedIntervalTypeBothAndUnopendTest() {
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(10, 15, IntervalType.UNOPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(15, 20, IntervalType.UNOPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(20, 25, IntervalType.UNOPENED)));
		assertTrue(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(25, 30, IntervalType.UNOPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(30, 35, IntervalType.UNOPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(35, 40, IntervalType.UNOPENED)));
		assertFalse(bothValidator.validator(bothOpenedPivot, IntervalFactory.getInterval(40, 45, IntervalType.UNOPENED)));
		
	}


}
