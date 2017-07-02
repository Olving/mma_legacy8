		package mma.legacy.interval.api.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludedIntervaltypeUnopenedValidator implements IncludedIntervalValidatorStrategy{

	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;

	public IncludedIntervaltypeUnopenedValidator() {
		this.includeValueValidator = new IncludeValueValidator();
		this.bdComparator = new BigDecimalComparator();
	}
	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
		
		
	
		
		boolean isMinimunIncluded = includeValueValidator.validate(intervalComparador, interval.getMinimum());
	
	
		boolean isMaximumIncluded = includeValueValidator.validate(intervalComparador, interval.getMaximum());
	

		return isMinimunIncluded && isMaximumIncluded;
				
	
	}

}
