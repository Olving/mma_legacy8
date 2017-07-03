package mma.legacy.interval.api.include.value.validator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;

public interface IncludeValueValidatorStategy {
	public boolean validate(Interval interval,BigDecimal value);
}
