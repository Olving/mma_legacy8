package mma.legacy.interval.api.include.value.validator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludeValueTypeBothValidator  implements IncludeValueValidatorStategy{
	BigDecimalComparator bdComparator;
	public IncludeValueTypeBothValidator() {
		
		bdComparator=new BigDecimalComparator();
	}

	
	public boolean validate(Interval interval,BigDecimal value){
		return bdComparator.isBiger(interval.getMinimum(),value)&& bdComparator.isSmaller(interval.getMaximum(),value);
	}


	

}
