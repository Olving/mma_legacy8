package mma.legacy.interval.included.validator;

import mma.legacy.interval.Interval;

public interface IncludedIntervalValidatorStrategy {
	public boolean validator (Interval intervalComparador, Interval interval);

}
