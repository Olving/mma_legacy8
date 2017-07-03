package mma.legacy.interval.api.include.interval.validator;

import mma.legacy.interval.Interval;

/**
 * Clase con la responsabilidad de validar si un intervalo esta dentro de otro intervalo 
 * @author JosepPC 
 */
public class IncludedIntervalValidator implements IncludedIntervalValidatorStrategy{
	
	private IncludedIntervalValidatorStrategy bothValidator;
	private IncludedIntervalValidatorStrategy leftValidator;
	private IncludedIntervalValidatorStrategy rightValidator;
	private IncludedIntervalValidatorStrategy unopenedValidator;
	
	public IncludedIntervalValidator(){
		bothValidator=new IncludedIntervaltypeBothValidator();
		leftValidator =new IncludedIntervaltypeLeftValidator();
		rightValidator=new IncludedIntervaltypeRightValidator();
		unopenedValidator =new IncludedIntervaltypeUnopenedValidator();
	}
	
	
	@Override
	public boolean validate(Interval intervalComparador, Interval interval) {
		switch (intervalComparador.getIntervalType()) {
		case BOTH_OPENED:
			return bothValidator.validate(intervalComparador, interval);
		case LEFT_OPENED:
			return leftValidator.validate(intervalComparador, interval);
			
		case RIGHT_OPENED:
			return rightValidator.validate(intervalComparador, interval);
		case UNOPENED:
			return unopenedValidator.validate(intervalComparador, interval);
		default:
			return false;
		}
	}

}
