		package mma.legacy.interval.included.validator;

import mma.legacy.interval.BigDecimalComparator;
import mma.legacy.interval.IncludeValueValidator;
import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalType;

public class IncludedIntervaltypeUnopenedValidator implements IncludedIntervalValidatorStrategy{

	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;

	public IncludedIntervaltypeUnopenedValidator() {
		this.includeValueValidator = new IncludeValueValidator();
		this.bdComparator = new BigDecimalComparator();
	}
	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
		boolean isMinimunIncluded = false;
		boolean isMaximumIncluded = false;
		
	
		
		
			isMinimunIncluded = includeValueValidator.validate(intervalComparador, interval.getMinimum());
	
	
			isMaximumIncluded = includeValueValidator.validate(intervalComparador, interval.getMaximum());
	

		return isMinimunIncluded && isMaximumIncluded;
				
	
	}

//	@Override
//	public boolean validator(Interval intervalComparador, Interval interval) {
//		switch (interval.getIntervalType()) {
//		case BOTH_OPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
//					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
//		case LEFT_OPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
//					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
//		case RIGHT_OPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
//					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
//		case UNOPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
//					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
//		default:
//			assert false;
//			return false;
//		}
//	}
//
//	
	
}
