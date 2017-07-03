package mma.legacy.interval.api.include.value.validator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludeValueTypeRightValidator  implements IncludeValueValidatorStategy{
	BigDecimalComparator bdComparator;
	public IncludeValueTypeRightValidator() {
		
		bdComparator=new BigDecimalComparator();
	}

	
	
	public boolean validate(Interval interval,BigDecimal value){
		return bdComparator.isBigerOrEquals(interval.getMinimum(),value)  && bdComparator.isSmaller(interval.getMaximum(),value);
	}
	
	
	

}
