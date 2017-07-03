package mma.legacy.interval.include.interval.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalFactory;
import mma.legacy.interval.IntervalType;
import mma.legacy.interval.IntervalsTestCreator;
import mma.legacy.interval.api.include.interval.validator.IncludedIntervalValidatorStrategy;
import mma.legacy.interval.api.include.interval.validator.IncludedIntervaltypeUnopenedValidator;

public class IncludedIntervaltypeUnopenedValidatorTest {

	private Interval unOpenedPivot;

	private IncludedIntervalValidatorStrategy unopenedValidator;

	@Before
	public void setup() {
		this.unOpenedPivot = IntervalFactory.getInterval(20, 35, IntervalType.UNOPENED);
		unopenedValidator=new IncludedIntervaltypeUnopenedValidator();
	}
	
	
	
	
	@Test
	public void isIncludedIntervalTypeUnopenedTest() {	
		
		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.BOTH_OPENED);
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(0)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(1)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(2)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(3)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(4)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(5)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(6)));
		
	}

	@Test
	public void isIncludedIntervalTypeUnopenedLeftTest() {
		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.LEFT_OPENED);
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(0)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(1)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(2)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(3)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(4)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(5)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(6)));
		
		
	}

	@Test
	public void isIncludedIntervalTypeUnopenedRightTest() {
		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.RIGHT_OPENED);
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(0)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(1)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(2)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(3)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(4)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(5)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(6)));
		
	}

	@Test
	public void isIncludedIntervalTypeUnopenedtTest() {
		List<Interval> intervals=IntervalsTestCreator.create(IntervalType.UNOPENED);
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(0)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(1)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(2)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(3)));
		assertTrue(unopenedValidator.validator(unOpenedPivot,intervals.get(4)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(5)));
		assertFalse(unopenedValidator.validator(unOpenedPivot,intervals.get(6)));

	}
}
