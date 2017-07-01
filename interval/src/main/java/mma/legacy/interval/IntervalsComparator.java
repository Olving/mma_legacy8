package mma.legacy.interval;

import java.util.logging.Logger;

public class IntervalsComparator {
	

	public IntervalsComparator() {}
	private static final Logger LOGGER = Logger.getLogger(Interval.class.getName());
	
	/**
	 * Valida que el parametro de entra value
	 * este dentro de los limites del intervalo
	 * @param value
	 * @throws NulPointerException
	 * @return boolean
	 */
	public boolean isWithinInterval(Interval interval,double value) {
		LOGGER.info("Entro en el método isWithinInterval");
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			return interval.getMinimum() < value && value < interval.getMaximum();
		case LEFT_OPENED:
			return interval.getMinimum() < value && value <= interval.getMaximum();
		case RIGHT_OPENED:
			return interval.getMinimum() <= value && value < interval.getMaximum();
		case UNOPENED:
			return interval.getMinimum() <= value && value <= interval.getMaximum();
		default:
			return false;
		}
	}
	
	


	public boolean isIncluidedInterval(Interval intervalComparador, Interval interval) {
		boolean minimumIncluded = isWithinInterval(intervalComparador,interval.getMinimum());
		boolean maximumIncluded = isWithinInterval(intervalComparador,interval.getMaximum());
		switch (intervalComparador.getIntervalType()) {
		case BOTH_OPENED:
			return isIncludedIntervalTypeBoth(intervalComparador,interval, minimumIncluded, maximumIncluded);
		case LEFT_OPENED:
			return isIncludedIntervalTypeLeft(intervalComparador,interval, minimumIncluded, maximumIncluded);
		case RIGHT_OPENED:
			return isIncludedIntervalTypeRight(intervalComparador,interval, minimumIncluded, maximumIncluded);
		case UNOPENED:
			return isIncludedIntervalTypeUnopened(intervalComparador,interval, minimumIncluded, maximumIncluded);
		default:
			return false;
		}
	} 
	
	private boolean isIncludedIntervalTypeUnopened(Interval intervalComparador,Interval interval, boolean minimumIncluded,
			boolean maximumIncluded) {
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case LEFT_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case RIGHT_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		default:
			assert false;
			return false;
		}
	}

	private boolean isIncludedIntervalTypeRight(Interval intervalComparador,Interval interval, boolean minimumIncluded, boolean maximumIncluded) {
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case LEFT_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum()) && (maximumIncluded);
		case RIGHT_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum()) && (maximumIncluded);
		default:
			assert false;
			return false;
		}
	}

	private boolean isIncludedIntervalTypeLeft(Interval intervalComparador,Interval interval, boolean minimumIncluded, boolean maximumIncluded) {
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case LEFT_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case RIGHT_OPENED:
			return (minimumIncluded) && (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded) && (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		default:
			assert false;
			return false;
		}
	}

	private boolean isIncludedIntervalTypeBoth(Interval intervalComparador,Interval interval, boolean minimumIncluded, boolean maximumIncluded) {
		switch (interval.getIntervalType()) {
		case BOTH_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case LEFT_OPENED:
			return (minimumIncluded || intervalComparador.getMinimum() == interval.getMinimum()) && (maximumIncluded);
		case RIGHT_OPENED:
			return (minimumIncluded) && (maximumIncluded || intervalComparador.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded) && (maximumIncluded);
		default:
			return false;
		}
	}
	
}