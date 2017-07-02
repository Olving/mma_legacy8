package mma.legacy.interval.api.validator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludeValueValidator  {
	BigDecimalComparator bdComparator;
	public IncludeValueValidator() {
		
		bdComparator=new BigDecimalComparator();
	}

	/**
	 * Valida que el parametro de entra value
	 * este dentro de los limites del intervalo
	 * @param value
	 * @throws NulPointerException
	 * @return boolean
	 */
	public boolean validate(Interval interval,BigDecimal value) {
		boolean result;
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			result= bothValidate(interval, value);
		case LEFT_OPENED:
			result=  leftValidate(interval, value);
		case RIGHT_OPENED:
			result=  rightValidate(interval, value);
		case UNOPENED:
			result=  unopenedValidate(interval, value);
		default:
			result=  false;
		}
		
		return result;
	}
	
	private boolean bothValidate(Interval interval,BigDecimal value){
		return bdComparator.isBiger(interval.getMinimum(),value)&& bdComparator.isSmaller(interval.getMaximum(),value);
	}

	private boolean leftValidate(Interval interval,BigDecimal value){
		return bdComparator.isBiger(interval.getMinimum(),value)  && bdComparator.isSmallerOrEquals(interval.getMaximum(),value);
	}
	
	private boolean rightValidate(Interval interval,BigDecimal value){
		return bdComparator.isBigerOrEquals(interval.getMinimum(),value)  && bdComparator.isSmaller(interval.getMaximum(),value);
	}
	
	private boolean unopenedValidate(Interval interval,BigDecimal value){
		return bdComparator.isBigerOrEquals(interval.getMinimum(),value)  && bdComparator.isSmallerOrEquals(interval.getMaximum(),value);
	}
	

}
