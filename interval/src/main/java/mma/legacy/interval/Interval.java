package mma.legacy.interval;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * Clase para el ejemplo de trabajo con Legacy
 * 
 * @author Agustin Controla operaciones sobre intervalos que pudeen ser abiertos
 *         o cerrados
 */
public class Interval {

	private BigDecimal minimum; // número entero que indica el limite inferior del
							// intervalo
	private BigDecimal maximum; // número entero que indica el limite superior del
							// intervalo
	private IntervalType intervalType; // Valor que indica el tipo de  intervalo es
								// abierto derecha , abierto izquierda, los 2 abiertos ,cerrado 
	
	
	private IntervalsApi calculatorApi;
	
	
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
		this.minimum = BigDecimal.valueOf(minimum);
		this.maximum = BigDecimal.valueOf(maximum);
		this.intervalType=intervalType;
 		calculatorApi=new IntervalsApi();
 		
		LOGGER.info("Objeto Interval creado");
	}	

	
	

	public BigDecimal getMinimum() {
		return minimum;
	}


	public BigDecimal getMaximum() {
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
	
		return calculatorApi.calcutetMidPoint(this).doubleValue();
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
		return calculatorApi.isWithinInterval(this, new BigDecimal(value));
	}

	/**
	 * Verifica que un intervalo este dentro de otro intervalo
	 * @param interval
	 * @throws NulPointerException
	 * @return boolean
	 */
	public boolean isIncludedInterval(Interval interval) {
		return calculatorApi.isIncluidedInterval(this, interval);
	}

	

	/**
	 * Verifica si existe interseccion entre dos intervalos
	 * @param interval
	 * @return bolean
	 */

	public boolean intersectsWith(Interval interval) {
		if (minimum.compareTo(interval.maximum)==0) {
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
		if (maximum.compareTo(interval.minimum)==0) {
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
		return this.isWithinInterval(interval.minimum.doubleValue()) || this.isWithinInterval(interval.maximum.doubleValue());
	}

}
