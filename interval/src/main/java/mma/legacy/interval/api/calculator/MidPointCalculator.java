package mma.legacy.interval.api.calculator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;

/**
 * Clase con la responsabilidad de calcular el punto medio de un intervalo 
 * @author JosepPC 
 */
public class MidPointCalculator {
	
	
	public BigDecimal calculate(Interval interval) {
		if(interval!=null){
			return interval.getMinimum().add(interval.getMaximum()).divide( BigDecimal.valueOf(2d));
		}
		
		return BigDecimal.valueOf(0);
	}

}
