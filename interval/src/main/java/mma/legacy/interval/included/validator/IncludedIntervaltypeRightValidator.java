		package mma.legacy.interval.included.validator;

import mma.legacy.interval.BigDecimalComparator;
import mma.legacy.interval.IncludeValueValidator;
import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalType;

public class IncludedIntervaltypeRightValidator implements IncludedIntervalValidatorStrategy{

	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;

	public IncludedIntervaltypeRightValidator() {
		this.includeValueValidator = new IncludeValueValidator();
		this.bdComparator = new BigDecimalComparator();
	}
	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
		boolean isMinimunIncluded = false;
		boolean isMaximumIncluded = false;
		
		
		if (interval.getIntervalType().equals(IntervalType.RIGHT_OPENED)||interval.getIntervalType().equals(IntervalType.BOTH_OPENED)) {
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
	
	
	
	

//	@Override
//	public boolean validator(Interval intervalComparador, Interval interval) {
//		switch (interval.getIntervalType()) {
//		case BOTH_OPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
//					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
//		case LEFT_OPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum()) && (maximumIncluded);
//		case RIGHT_OPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
//					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
//		case UNOPENED:
//			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum()) && (maximumIncluded);
//		default:
//			assert false;
//			return false;
//		}
//		
//	}

	
	
}
