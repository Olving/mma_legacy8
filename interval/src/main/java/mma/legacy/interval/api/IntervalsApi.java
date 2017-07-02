package mma.legacy.interval.api;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.calculator.MidPointCalculator;
import mma.legacy.interval.api.validator.IncludeValueValidator;
import mma.legacy.interval.api.validator.IncludedIntervalValidator;


/**
 * Esta clase es el punto de entrada para el desarrollador Permite ejecutar todas las operaciones de Intervalos.
 * @author Agustin
 *
 */
public class IntervalsApi {
	
private IncludeValueValidator withinIntervalValidator;
private MidPointCalculator midPointCalculator;
private IncludedIntervalValidator includedValidator;

	public IntervalsApi() {
		 this.withinIntervalValidator=new IncludeValueValidator();
		 this.midPointCalculator=new MidPointCalculator();
		 this.includedValidator=new IncludedIntervalValidator();
	}

	/**
	 * Calcula el punto medio de un intervalo
	 * @return double
	 */
	public double calcutetMidPoint(Interval interval){
		return midPointCalculator.calculate(interval).doubleValue();
	}
	/**
	 * Valida que el parametro de entra value
	 * este dentro de los limites del intervalo
	 * @param value
	 * @return boolean
	 */
	public boolean isWithinInterval(Interval interval, double value) {
		
		return withinIntervalValidator.validate(interval,  BigDecimal.valueOf(value));
	}

	/**
	 * Verifica que un intervalo este dentro de otro intervalo
	 * @param interval
	 * @return boolean
	 */
	public boolean isIncluidedInterval(Interval intervalComparador, Interval interval) {
		return includedValidator.validator(intervalComparador, interval);
	} 
	


	/**
	 * Verifica si existe interseccion entre dos intervalos
	 * @param interval
	 * @return bolean
	 */

	public boolean intersectsWith(Interval interval) {
//		if (minimum.compareTo(interval.maximum)==0) {
//			switch (intervalType) {
//			case BOTH_OPENED:
//			case LEFT_OPENED:
//				return false;
//			case RIGHT_OPENED:
//			case UNOPENED:
//				return interval.intervalType == IntervalType.LEFT_OPENED || interval.intervalType == IntervalType.UNOPENED;
//			default:
//				assert false;
//				return false;
//			}
//		}
//		if (maximum.compareTo(interval.minimum)==0) {
//			switch (intervalType) {
//			case BOTH_OPENED:
//			case RIGHT_OPENED:
//				return false;
//			case LEFT_OPENED:
//			case UNOPENED:
//				return interval.intervalType == IntervalType.RIGHT_OPENED || interval.intervalType == IntervalType.UNOPENED;
//			default:
//				assert false;
//				return false;
//			}
//		}
//		return this.isWithinInterval(interval.minimum.doubleValue()) || this.isWithinInterval(interval.maximum.doubleValue());
	return false;
	}
	
}