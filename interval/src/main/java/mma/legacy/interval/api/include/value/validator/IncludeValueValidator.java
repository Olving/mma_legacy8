package mma.legacy.interval.api.include.value.validator;

import java.math.BigDecimal;

import mma.legacy.interval.Interval;

/**
 * Clase con la responsabilidad de validar si un valor esta dentro de un intervalo 
 * @author JosepPC 
 */
public class IncludeValueValidator  implements IncludeValueValidatorStategy{
	private IncludeValueValidatorStategy bothValidator;
	private IncludeValueValidatorStategy unopenedValidator;
	private IncludeValueValidatorStategy leftValidator;
	private IncludeValueValidatorStategy rightValidator;
	
	public IncludeValueValidator() {
		
		bothValidator=new IncludeValueTypeBothValidator();
		unopenedValidator=new IncludeValueTypeUnopenedValidator();
		rightValidator=new IncludeValueTypeRightValidator();
		leftValidator=new IncludeValueTypeLeftValidator();
		
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
			return bothValidator.validate(interval, value);
		case LEFT_OPENED:
			return leftValidator.validate(interval, value);
		case RIGHT_OPENED:
			return rightValidator.validate(interval, value);
		case UNOPENED:
			return unopenedValidator.validate(interval, value);
		default:
			return false;
		}
	}
	

	
}
