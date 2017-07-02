package mma.legacy.interval.api.validator;

import java.math.BigDecimal;
import java.util.logging.Logger;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.comparator.BigDecimalComparator;

public class IncludeValueValidator  {
	BigDecimalComparator bdComparator;
	public IncludeValueValidator() {
		
		bdComparator=new BigDecimalComparator();
	}
	private static final Logger LOGGER = Logger.getLogger(IncludeValueValidator.class.getName());

	
	/**
	 * Valida que el parametro de entra value
	 * este dentro de los limites del intervalo
	 * @param value
	 * @throws NulPointerException
	 * @return boolean
	 */
	public boolean validate(Interval interval,BigDecimal value) {
		LOGGER.info("Entro en el método isWithinInterval");
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			return bdComparator.isBiger(interval.getMinimum(),value)&& bdComparator.isSmaller(interval.getMaximum(),value);
		case LEFT_OPENED:
			return bdComparator.isBiger(interval.getMinimum(),value)  && bdComparator.isSmallerOrEquals(interval.getMaximum(),value);
		case RIGHT_OPENED:
			return bdComparator.isBigerOrEquals(interval.getMinimum(),value)  && bdComparator.isSmaller(interval.getMaximum(),value);
		case UNOPENED:
			return bdComparator.isBigerOrEquals(interval.getMinimum(),value)  && bdComparator.isSmallerOrEquals(interval.getMaximum(),value);
		default:
			return false;
		}
	}
	
	

	

}
