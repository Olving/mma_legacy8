package mma.legacy.interval;

import java.math.BigDecimal;

public class MidPointCalculator {
	
	
	public BigDecimal calculate(Interval interval) {
		return(interval.getMinimum().add(interval.getMaximum()).divide( BigDecimal.valueOf(2d)));
	}

}
