package mma.legacy.interval.api.include.interval.validator;

import mma.legacy.interval.Interval;

public class IncludedIntervalValidator implements IncludedIntervalValidatorStrategy{
	
	private IncludedIntervalValidatorStrategy bothValidator;
	private IncludedIntervalValidatorStrategy leftValidator;
	private IncludedIntervalValidatorStrategy rightValidator;
	private IncludedIntervalValidatorStrategy unopenedValidator;
	
	public IncludedIntervalValidator(){
		bothValidator=new IncludedIntervaltypeBothValidator();
		leftValidator =new IncludedIntervaltypeLeftValidator();
		rightValidator=new IncludedIntervaltypeRightValidator();
		unopenedValidator =new IncludedIntervaltypeUnopenedValidator();
	}
	
	
	@Override
	public boolean validator(Interval intervalComparador, Interval interval) {
		switch (intervalComparador.getIntervalType()) {
		case BOTH_OPENED:
			return bothValidator.validator(intervalComparador, interval);
		case LEFT_OPENED:
			return leftValidator.validator(intervalComparador, interval);
			
		case RIGHT_OPENED:
			return rightValidator.validator(intervalComparador, interval);
		case UNOPENED:
			return unopenedValidator.validator(intervalComparador, interval);
		default:
			return false;
		}
	}

}
