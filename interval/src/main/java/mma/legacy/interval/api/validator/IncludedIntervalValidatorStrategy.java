package mma.legacy.interval.api.validator;

import mma.legacy.interval.Interval;

public interface IncludedIntervalValidatorStrategy {
	public boolean validator (Interval intervalComparador, Interval interval);

}
