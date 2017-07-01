package mma.legacy.interval;

import java.util.logging.Logger;

/**
 * Clase para el ejemplo de trabajo con Legacy
 * 
 * @author Agustin Controla operaciones sobre intervalos que pudeen ser abiertos
 *         o cerrados
 */
public class Interval {

	private double minimum; // número entero que indica el limite inferior del
							// intervalo
	private double maximum; // número entero que indica el limite superior del
							// intervalo
	private IntervalType opening; // Valor que indica el tipo de  intervalo es
								// abierto derecha , abierto izquierda, los 2 abiertos ,cerrado 
	
	
	private static final Logger LOGGER = Logger.getLogger(Interval.class.getName());


	/**
	 * Constructor de la clase
	 * 
	 * @param minimum
	 * @param maximum
	 * @param opening
	 *            Todos los parámetros pueden ser nulos
	 */
	public Interval(double minimum, double maximum, IntervalType opening) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.opening = opening;
		LOGGER.info("Objeto Interval creado");
	}

	/**
	 * Calcula el punto medio de un intervalo
	 * @return double
	 */
	public double getMidPoint() {
		return (maximum + minimum) / 2;
	}

	/**
	 * Valida que el parametro de entra value
	 * este dentro de los limites del intervalo
	 * @param value
	 * @throws NulPointerException
	 * @return boolean
	 */
	public boolean isWithinInterval(double value) {
		LOGGER.info("Entro en el método isWithinInterval");

		switch (opening) {
		case BOTH_OPENED:
			return minimum < value && value < maximum;
		case LEFT_OPENED:
			return minimum < value && value <= maximum;
		case RIGHT_OPENED:
			return minimum <= value && value < maximum;
		case UNOPENED:
			return minimum <= value && value <= maximum;
		default:
			return false;
		}
	}

	/**
	 * Verifica que un intervalo este dentro de otro intervalo
	 * @param interval
	 * @throws NulPointerException
	 * @return boolean
	 */
	public boolean isIncludedInterval(Interval interval) {
		boolean minimumIncluded = this.isWithinInterval(interval.minimum);
		boolean maximumIncluded = this.isWithinInterval(interval.maximum);
		switch (opening) {
		case BOTH_OPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum) && (maximumIncluded);
			case RIGHT_OPENED:
				return (minimumIncluded) && (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded) && (maximumIncluded);
			default:
				assert false;
				return false;
			}
		case LEFT_OPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case RIGHT_OPENED:
				return (minimumIncluded) && (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded) && (maximumIncluded || maximum == interval.maximum);
			default:
				assert false;
				return false;
			}
		case RIGHT_OPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum) && (maximumIncluded);
			case RIGHT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded || minimum == interval.minimum) && (maximumIncluded);
			default:
				assert false;
				return false;
			}
		case UNOPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case RIGHT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			default:
				assert false;
				return false;
			}
		default:
			assert false;
			return false;
		}
	}

	/**
	 * Verifica si existe interseccion entre dos intervalos
	 * @param interval
	 * @return bolean
	 */

	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
			switch (opening) {
			case BOTH_OPENED:
			case LEFT_OPENED:
				return false;
			case RIGHT_OPENED:
			case UNOPENED:
				return interval.opening == IntervalType.LEFT_OPENED || interval.opening == IntervalType.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		if (maximum == interval.minimum) {
			switch (opening) {
			case BOTH_OPENED:
			case RIGHT_OPENED:
				return false;
			case LEFT_OPENED:
			case UNOPENED:
				return interval.opening == IntervalType.RIGHT_OPENED || interval.opening == IntervalType.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		return this.isWithinInterval(interval.minimum) || this.isWithinInterval(interval.maximum);
	}

}
