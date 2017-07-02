package mma.legacy.interval.api.validator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalType;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IntersectionIntervalsValidator {
	
	
	private IncludeValueValidator includeValueValidator;
	private BigDecimalComparator bdComparator;
	
	public IntersectionIntervalsValidator(){
		includeValueValidator=new IncludeValueValidator();
		bdComparator=new BigDecimalComparator();
	}
	
	public boolean validate(Interval intervalComparador,Interval interval) {
		
		return includeValueValidator.validate(intervalComparador,interval.getMinimum()) || includeValueValidator.validate(intervalComparador,interval.getMaximum());
		

	}
	
	
	
	

}
