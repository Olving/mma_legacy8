package mma.legacy.interval;

import java.math.BigDecimal;

import mma.legacy.interval.included.validator.IncludedIntervalValidator;


public class IntervalsApi {
	
private IncludeValueValidator withinIntervalValidator;
private MidPointCalculator midPointCalculator;
private IncludedIntervalValidator includedValidator;

	public IntervalsApi() {
		 this.withinIntervalValidator=new IncludeValueValidator();
		 this.midPointCalculator=new MidPointCalculator();
		 this.includedValidator=new IncludedIntervalValidator();
	}

	
	public BigDecimal calcutetMidPoint(Interval interval){
		return midPointCalculator.calculate(interval);
	}
	
	public boolean isWithinInterval(Interval interval, BigDecimal value) {
		
		return withinIntervalValidator.validate(interval, value);
	}


	public boolean isIncluidedInterval(Interval intervalComparador, Interval interval) {
		return includedValidator.validator(intervalComparador, interval);
	} 
	


	
	
}