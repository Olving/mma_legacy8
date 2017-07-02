		package mma.legacy.interval.api.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalType;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludedIntervaltypeRightValidator implements IncludedIntervalValidatorStrategy{

	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;

	public IncludedIntervaltypeRightValidator() {
		this.includeValueValidator = new IncludeValueValidator();
		this.bdComparator = new BigDecimalComparator();
	}
	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
	
		boolean isMaximumIncluded = false;
		
		
		if (interval.getIntervalType().equals(IntervalType.RIGHT_OPENED)||interval.getIntervalType().equals(IntervalType.BOTH_OPENED)) {
			isMaximumIncluded = bdComparator.areEquals(intervalComparador.getMaximum(), interval.getMaximum());
			
		}
	
		
		
		boolean isMinimunIncluded = includeValueValidator.validate(intervalComparador, interval.getMinimum());
		
		if (!isMaximumIncluded) {
			isMaximumIncluded = includeValueValidator.validate(intervalComparador, interval.getMaximum());
		}

		return isMinimunIncluded && isMaximumIncluded;
		
		
	}
	
	
	
}
