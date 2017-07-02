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
		
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			return bothValidate(interval, value);
		case LEFT_OPENED:
			return leftValidate(interval, value);
		case RIGHT_OPENED:
			return rightValidate(interval, value);
		case UNOPENED:
			return unopenedValidate(interval, value);
		default:
			return false;
		}
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
