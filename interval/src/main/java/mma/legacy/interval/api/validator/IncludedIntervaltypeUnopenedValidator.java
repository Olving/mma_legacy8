		package mma.legacy.interval.api.validator;

import mma.legacy.interval.Interval;

public class IncludedIntervaltypeUnopenedValidator implements IncludedIntervalValidatorStrategy{

	private IncludeValueValidator includeValueValidator;


	public IncludedIntervaltypeUnopenedValidator() {
		this.includeValueValidator = new IncludeValueValidator();
	}
	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
		
		
	
		
		boolean isMinimunIncluded = includeValueValidator.validate(intervalComparador, interval.getMinimum());
	
	
		boolean isMaximumIncluded = includeValueValidator.validate(intervalComparador, interval.getMaximum());
	

		return isMinimunIncluded && isMaximumIncluded;
				
	
	}

}
