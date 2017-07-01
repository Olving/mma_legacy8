package mma.legacy.interval;


/**
 * Esta clase del tipo factoria tiene la responsabilidad de crear clases del tipo Interval.
 * @author Agustin
 *
 */
public class IntervalFactory {
	
	
	private IntervalFactory() {}

	public static Interval getInterval(double minimum, double maximum, IntervalType opening) {
		return new Interval(minimum, maximum, opening);
	}
}
