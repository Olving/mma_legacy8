package mma.legacy.interval;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * Clase para el ejemplo de trabajo con Legacy.Permite definir un Intervalo 
 * @author Agustin 
 */
public class Interval {

	private BigDecimal minimum; // número entero que indica el limite inferior del
							// intervalo
	private BigDecimal maximum; // número entero que indica el limite superior del
							// intervalo
	private IntervalType intervalType; // Valor que indica el tipo de  intervalo es
								// abierto derecha , abierto izquierda, los 2 abiertos ,cerrado 
	
	
	
	private static final Logger LOGGER = Logger.getLogger(Interval.class.getName());

	
	
	/**
	 * Constructor de la clase
	 * 
	 * @param minimum
	 * @param maximum
	 * @param opening
	 * 
	 */
	protected Interval(double minimum, double maximum, IntervalType intervalType) {
		this.minimum = BigDecimal.valueOf(minimum);
		this.maximum = BigDecimal.valueOf(maximum);
		this.intervalType=intervalType;		
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
	
}
