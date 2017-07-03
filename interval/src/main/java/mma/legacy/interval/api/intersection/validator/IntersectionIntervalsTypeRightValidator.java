package mma.legacy.interval.api.intersection.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IntersectionIntervalsTypeRightValidator implements IntersectionIntervalsValiatorStrategy{
	private BigDecimalComparator bdComparator;
	private IntersectionIntervalsValiatorStrategy commonValidator;
	public IntersectionIntervalsTypeRightValidator() {
		bdComparator=new BigDecimalComparator();
		commonValidator=new IntersectionIntervalsCommonValidator();
	}
	
	
	public boolean validate(Interval intervalComparador,Interval interval){
		switch (interval.getIntervalType()) {
		case RIGHT_OPENED:
		case BOTH_OPENED:
			if(bdComparator.areEquals(intervalComparador.getMinimum(), interval.getMaximum())){
				return false;
			}
		default:
			return commonValidator.validate(intervalComparador, interval);
		}
		
	
	}

}