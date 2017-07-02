package mma.legacy.interval.included.validator;

import mma.legacy.interval.BigDecimalComparator;
import mma.legacy.interval.IncludeValueValidator;
import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalType;

public class IncludedIntervaltypeBothValidator implements IncludedIntervalValidatorStrategy {
	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;

	public IncludedIntervaltypeBothValidator() {
		this.includeValueValidator = new IncludeValueValidator();
		this.bdComparator = new BigDecimalComparator();
	}

	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
		boolean isMinimunIncluded = false;
		boolean isMaximumIncluded = false;

		if (interval.getIntervalType().equals(IntervalType.BOTH_OPENED)||interval.getIntervalType().equals(IntervalType.LEFT_OPENED)) {
			isMinimunIncluded = bdComparator.areEquals(intervalComparador.getMinimum(), interval.getMinimum());
			
		}
		
		if (interval.getIntervalType().equals(IntervalType.BOTH_OPENED)||interval.getIntervalType().equals(IntervalType.RIGHT_OPENED)) {
			isMaximumIncluded = bdComparator.areEquals(intervalComparador.getMaximum(), interval.getMaximum());
		}
		
		if (!isMinimunIncluded) {
			isMinimunIncluded = includeValueValidator.validate(intervalComparador, interval.getMinimum());
		}
		if (!isMaximumIncluded) {
			isMaximumIncluded = includeValueValidator.validate(intervalComparador, interval.getMaximum());
		}

		return isMinimunIncluded && isMaximumIncluded;

	}

	

}
