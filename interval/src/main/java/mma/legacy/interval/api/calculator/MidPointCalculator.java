package mma.legacy.interval.api.calculator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;

public class MidPointCalculator {
	
	
	public BigDecimal calculate(Interval interval) {
		return(interval.getMinimum().add(interval.getMaximum()).divide( BigDecimal.valueOf(2d)));
	}

}
