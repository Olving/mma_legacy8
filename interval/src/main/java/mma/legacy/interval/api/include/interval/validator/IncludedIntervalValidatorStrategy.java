package mma.legacy.interval.api.include.interval.validator;

import mma.legacy.interval.Interval;

public interface IncludedIntervalValidatorStrategy {
	public boolean validator (Interval intervalComparador, Interval interval);

}
