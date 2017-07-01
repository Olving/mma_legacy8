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
	private IntervalType intervalType; // Valor que indica el tipo de  intervalo es
								// abierto derecha , abierto izquierda, los 2 abiertos ,cerrado 
	
	
	private IntervalsComparator comparator;
	
	private static final Logger LOGGER = Logger.getLogger(Interval.class.getName());

	
	
	/**
	 * Constructor de la clase
	 * 
	 * @param minimum
	 * @param maximum
	 * @param opening
	 *            Todos los parámetros pueden ser nulos
	 */
	public Interval(double minimum, double maximum, IntervalType intervalType) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.intervalType=intervalType;
 		comparator=new IntervalsComparator();
		LOGGER.info("Objeto Interval creado");
	}	

	
	

	public double getMinimum() {
		return minimum;
	}



	public double getMaximum() {
		return maximum;
	}


	public IntervalType getIntervalType() {
		return intervalType;
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
		return comparator.isWithinInterval(this, value);
	}

	/**
	 * Verifica que un intervalo este dentro de otro intervalo
	 * @param interval
	 * @throws NulPointerException
	 * @return boolean
	 */
	public boolean isIncludedInterval(Interval interval) {
		return comparator.isIncluidedInterval(this, interval);
	}

	

	/**
	 * Verifica si existe interseccion entre dos intervalos
	 * @param interval
	 * @return bolean
	 */

	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
			switch (intervalType) {
			case BOTH_OPENED:
			case LEFT_OPENED:
				return false;
			case RIGHT_OPENED:
			case UNOPENED:
				return interval.intervalType == IntervalType.LEFT_OPENED || interval.intervalType == IntervalType.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		if (maximum == interval.minimum) {
			switch (intervalType) {
			case BOTH_OPENED:
			case RIGHT_OPENED:
				return false;
			case LEFT_OPENED:
			case UNOPENED:
				return interval.intervalType == IntervalType.RIGHT_OPENED || interval.intervalType == IntervalType.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		return this.isWithinInterval(interval.minimum) || this.isWithinInterval(interval.maximum);
	}

}
