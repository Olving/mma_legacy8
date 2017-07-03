package mma.legacy.interval.api.intersection.validator;

import mma.legacy.interval.Interval;

public class IntersectionIntervalsValidator implements IntersectionIntervalsValiatorStrategy {

	private IntersectionIntervalsValiatorStrategy lefttValidator;
	private IntersectionIntervalsValiatorStrategy unopenedValidate;
	private IntersectionIntervalsValiatorStrategy commonValidator;
	private IntersectionIntervalsValiatorStrategy rightValidator;

	public IntersectionIntervalsValidator() {
		rightValidator = new IntersectionIntervalsTypeRightValidator();
		lefttValidator = new IntersectionIntervalsTypeLeftValidator();
		unopenedValidate = new IntersectionIntervalsTypeUnopenedValidator();
		commonValidator = new IntersectionIntervalsCommonValidator();
	}

	public boolean validate(Interval intervalComparador, Interval interval) {
		switch (intervalComparador.getIntervalType()) {
		case LEFT_OPENED:
			return lefttValidator.validate(intervalComparador, interval);
		case RIGHT_OPENED:
			return rightValidator.validate(intervalComparador, interval);
		case UNOPENED:
			return unopenedValidate.validate(intervalComparador, interval);
		default:
			return commonValidator.validate(intervalComparador, interval);
		}

	}

}
