package mma.legacy.interval.api.intersection.validator;

import mma.legacy.interval.Interval;

public class IntersectionIntervalsTypeUnopenedValidator implements IntersectionIntervalsValiatorStrategy{
	

	private IntersectionIntervalsValiatorStrategy lefttValidator;
	private IntersectionIntervalsValiatorStrategy commonValidator;
	private IntersectionIntervalsValiatorStrategy rightValidator;
	public IntersectionIntervalsTypeUnopenedValidator(){
		rightValidator=new IntersectionIntervalsTypeRightValidator();
		lefttValidator=new IntersectionIntervalsTypeLeftValidator();
		commonValidator=new IntersectionIntervalsCommonValidator();
	}
	public boolean validate(Interval intervalComparador, Interval interval) {
		switch (interval.getIntervalType()) {
		case LEFT_OPENED:	
			return lefttValidator.validate(intervalComparador, interval);
		case RIGHT_OPENED:	
			return rightValidator.validate(intervalComparador, interval);		
		
		case BOTH_OPENED:
			return rightValidator.validate(intervalComparador, interval)&&lefttValidator.validate(intervalComparador, interval);
		
		default:
			return commonValidator.validate(intervalComparador, interval);
		}
		
	}

}