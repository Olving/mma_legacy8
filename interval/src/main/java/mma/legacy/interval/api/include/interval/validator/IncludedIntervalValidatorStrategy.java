package mma.legacy.interval.api.include.interval.validator;

import mma.legacy.interval.Interval;

public interface IncludedIntervalValidatorStrategy {
	public boolean validate (Interval intervalComparador, Interval interval);

}
