		package mma.legacy.interval.api.include.interval.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.include.value.validator.IncludeValueValidator;

public class IncludedIntervaltypeUnopenedValidator implements IncludedIntervalValidatorStrategy{

	private IncludeValueValidator includeValueValidator;


	public IncludedIntervaltypeUnopenedValidator() {
		this.includeValueValidator = new IncludeValueValidator();
	}
	@Override
	public boolean validate(Interval intervalComparador, Interval interval) {
		boolean isMinimunIncluded = includeValueValidator.validate(intervalComparador, interval.getMinimum());
		boolean isMaximumIncluded = includeValueValidator.validate(intervalComparador, interval.getMaximum());
		return isMinimunIncluded && isMaximumIncluded;
				
	}

}
