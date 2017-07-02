		package mma.legacy.interval.api.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalType;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludedIntervaltypeLeftValidator implements IncludedIntervalValidatorStrategy{
	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;

	public IncludedIntervaltypeLeftValidator() {
		this.includeValueValidator = new IncludeValueValidator();
		this.bdComparator = new BigDecimalComparator();
	}
	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
		boolean isMinimunIncluded = false;
		boolean isMaximumIncluded = false;
		
		if (interval.getIntervalType().equals(IntervalType.LEFT_OPENED)||interval.getIntervalType().equals(IntervalType.BOTH_OPENED)) {
			isMinimunIncluded = bdComparator.areEquals(intervalComparador.getMinimum(), interval.getMinimum());
			
		}
		
		if (!isMinimunIncluded) {
			isMinimunIncluded = includeValueValidator.validate(intervalComparador, interval.getMinimum());
		}
		
			isMaximumIncluded = includeValueValidator.validate(intervalComparador, interval.getMaximum());
		

		return isMinimunIncluded && isMaximumIncluded;
		
		
	}
	
}


	
	
