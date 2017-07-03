package mma.legacy.interval.api.include.value.validator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludeValueTypeLeftValidator  implements IncludeValueValidatorStategy{
	BigDecimalComparator bdComparator;
	public IncludeValueTypeLeftValidator() {
		
		bdComparator=new BigDecimalComparator();
	}

	


	public boolean validate(Interval interval,BigDecimal value){
		return bdComparator.isBiger(interval.getMinimum(),value)  && bdComparator.isSmallerOrEquals(interval.getMaximum(),value);
	}
	
	
	

}
