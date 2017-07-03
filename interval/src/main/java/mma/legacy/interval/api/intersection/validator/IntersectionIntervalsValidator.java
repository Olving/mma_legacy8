package mma.legacy.interval.api.intersection.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;
import mma.legacy.interval.api.include.value.validator.IncludeValueValidator;

public class IntersectionIntervalsValidator {
	
	
	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;
	
	public IntersectionIntervalsValidator(){
		includeValueValidator=new IncludeValueValidator();
		bdComparator=new BigDecimalComparator();
	}
	
	public boolean validate(Interval intervalComparador,Interval interval) {
		switch (intervalComparador.getIntervalType()) {
		case LEFT_OPENED:	
			return leftValidate(intervalComparador, interval);
		case RIGHT_OPENED:	
			return rightValidate(intervalComparador, interval);		
		case UNOPENED:	
			return unopenedValidate(intervalComparador, interval);		
		default:
			return commonValidate(intervalComparador, interval);
		}
		


	}
	
	private boolean unopenedValidate(Interval intervalComparador, Interval interval) {
		switch (interval.getIntervalType()) {
		case LEFT_OPENED:{
			
			if(bdComparator.areEquals(intervalComparador.getMaximum(), interval.getMinimum())){
				return false;
			}
			return commonValidate(intervalComparador, interval);
		}
		case RIGHT_OPENED:{
			
			if(bdComparator.areEquals(intervalComparador.getMinimum(), interval.getMaximum())){
				return false;
			}
			return commonValidate(intervalComparador, interval);
		}
		case BOTH_OPENED:{
			if(bdComparator.areEquals(intervalComparador.getMinimum(), interval.getMaximum())){
				return false;
			}
			if(bdComparator.areEquals(intervalComparador.getMaximum(), interval.getMinimum())){
				return false;
			}
		}	
		default:
			return commonValidate(intervalComparador, interval);
		}
		
	}

	private boolean rightValidate(Interval intervalComparador,Interval interval){
		switch (interval.getIntervalType()) {
		case RIGHT_OPENED:
		case BOTH_OPENED:
			if(bdComparator.areEquals(intervalComparador.getMinimum(), interval.getMaximum())){
				return false;
			}
		default:
			return commonValidate(intervalComparador, interval);
		}
		
	
	}
	
	private boolean leftValidate(Interval intervalComparador,Interval interval){
		switch (interval.getIntervalType()) {
		case LEFT_OPENED:
		case BOTH_OPENED:
			if(bdComparator.areEquals(intervalComparador.getMaximum(), interval.getMinimum())){
				return false;
			}
		default:
			return commonValidate(intervalComparador, interval);
		}
		
	
	}
	
	private boolean commonValidate(Interval intervalComparador,Interval interval){
		return includeValueValidator.validate(intervalComparador,interval.getMinimum()) || includeValueValidator.validate(intervalComparador,interval.getMaximum());
	}
	
	
	
	

}
