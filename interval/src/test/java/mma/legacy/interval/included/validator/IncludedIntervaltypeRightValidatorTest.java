package mma.legacy.interval.included.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalFactory;
import mma.legacy.interval.IntervalType;
import mma.legacy.interval.IntervalsTestCreator;

public class IncludedIntervaltypeRightValidatorTest {
	
	
	
	private Interval rightOpenedPivot;
	private IncludedIntervalValidatorStrategy rightValidator;

	
	
	@Before
	public void setup() {
		this.rightOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.RIGHT_OPENED);
		rightValidator=new IncludedIntervaltypeRightValidator();
		
	}
	
	
	
	@Test
	public void isIncludedIntervalTypeRightBothTest() {
		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.BOTH_OPENED);
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(0)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(1)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(2)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(3)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(4)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(5)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(6)));
	

	}

	@Test
	public void isIncludedIntervalTypeRightLeftTest() {

		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.LEFT_OPENED);
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(0)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(1)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(2)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(3)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(4)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(5)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(6)));
		

	}

	@Test
	public void isIncludedIntervalTypeRightTest() {
		
		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.RIGHT_OPENED);
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(0)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(1)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(2)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(3)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(4)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(5)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(6)));
		
	}
	
	
	@Test
	public void isIncludedIntervalTypeRightUnopenedTest() {
		
		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.UNOPENED);
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(0)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(1)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(2)));
		assertTrue(rightValidator.validator(rightOpenedPivot,intervals.get(3)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(4)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(5)));
		assertFalse(rightValidator.validator(rightOpenedPivot,intervals.get(6)));
		

	}
}
	
	
	

