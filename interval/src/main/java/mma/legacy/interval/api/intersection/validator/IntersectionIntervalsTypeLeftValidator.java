package mma.legacy.interval.api.intersection.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IntersectionIntervalsTypeLeftValidator implements IntersectionIntervalsValiatorStrategy {
	private IntersectionIntervalsValiatorStrategy commonValidator;
	private BigDecimalComparator bdComparator;
	public IntersectionIntervalsTypeLeftValidator() {
		commonValidator=new IntersectionIntervalsCommonValidator();
		bdComparator=new BigDecimalComparator();
	}

	
	public boolean validate(Interval intervalComparador,Interval interval){
		switch (interval.getIntervalType()) {
		case LEFT_OPENED:
		case BOTH_OPENED:
			if(bdComparator.areEquals(intervalComparador.getMaximum(), interval.getMinimum())){
				return false;
			}
		default:
			return commonValidator.validate(intervalComparador, interval);
		}
		
	
	}
	
}