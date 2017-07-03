package mma.legacy.interval.api.intersection.validator;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.include.value.validator.IncludeValueValidator;

public class IntersectionIntervalsCommonValidator implements IntersectionIntervalsValiatorStrategy{
	private IncludeValueValidator includeValueValidator;
	public IntersectionIntervalsCommonValidator() {
		includeValueValidator=new IncludeValueValidator();
	}
	
	
	public boolean validate(Interval intervalComparador,Interval interval){
			return includeValueValidator.validate(intervalComparador,interval.getMinimum()) || includeValueValidator.validate(intervalComparador,interval.getMaximum());
	
	}

}