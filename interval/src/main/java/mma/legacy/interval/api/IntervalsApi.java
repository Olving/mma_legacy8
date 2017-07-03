package mma.legacy.interval.api;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;
import mma.legacy.interval.api.calculator.MidPointCalculator;
import mma.legacy.interval.api.include.interval.validator.IncludedIntervalValidator;
import mma.legacy.interval.api.include.value.validator.IncludeValueValidator;
import mma.legacy.interval.api.intersection.validator.IntersectionIntervalsValidator;


/**
 * Esta clase es el punto de entrada. Permite ejecutar todas las operaciones relacionadas con  Intervalos.
 * @author Agustin
 *
 */
public class IntervalsApi {
	
private IncludeValueValidator includeValueValidator;
private MidPointCalculator midPointCalculator;
private IncludedIntervalValidator includedValidator;
private IntersectionIntervalsValidator intersectionValidator;

	public IntervalsApi() {
		 this.includeValueValidator=new IncludeValueValidator();
		 this.midPointCalculator=new MidPointCalculator();
		 this.includedValidator=new IncludedIntervalValidator();
		 this.intersectionValidator=new IntersectionIntervalsValidator();
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
	public boolean isValueWithinInterval(Interval interval, double value) {
		
		return includeValueValidator.validate(interval,  BigDecimal.valueOf(value));
	}

	/**
	 * Verifica que un intervalo este dentro de otro intervalo
	 * @param interval
	 * @return boolean
	 */
	public boolean isIncluidedInterval(Interval intervalComparador, Interval interval) {
		return includedValidator.validate(intervalComparador, interval);
	} 
	


	/**
	 * Verifica si existe interseccion entre dos intervalos
	 * @param interval
	 * @return bolean
	 */

	public boolean intersectsWith(Interval intervalComparador,Interval interval) {
		return intersectionValidator.validate(intervalComparador, interval);

	}
	
}