package mma.legacy.interval;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class IntervalScaffoldingTest {	

	private IntervalsApi intervalsApi;
	
	@Before
	public void setup(){
		intervalsApi=new IntervalsApi();
	}
	
	@Test
	public void calcula_el_punto_medio_de_un_intervalo(){
		Interval interval=new Interval(0,10,IntervalType.BOTH_OPENED);
		assertThat(intervalsApi.calcutetMidPoint(interval), is(5d));
		//Litime  inferior
		assertThat(intervalsApi.calcutetMidPoint(interval), not(4d));
		//limite superior
		assertThat(intervalsApi.calcutetMidPoint(interval), not(6d));
		
	}
	
	
	
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_del_tipo_ambos_abierto(){
		Interval interval=new Interval(0,10,IntervalType.BOTH_OPENED);
		
		assertThat(intervalsApi.isWithinInterval(interval, 7), is(true));
		//Limites inferiores
		assertThat(intervalsApi.isWithinInterval(interval, 0), is(false));
		assertThat(intervalsApi.isWithinInterval(interval, 1), is(true));
		//Limites superiores
		assertThat(intervalsApi.isWithinInterval(interval, 10), is(false));
		assertThat(intervalsApi.isWithinInterval(interval, 9), is(true));
		
	}
	
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_tipo_izquierda_abierto(){
		Interval interval=new Interval(0,10,IntervalType.LEFT_OPENED);
		assertThat(intervalsApi.isWithinInterval(interval, 7), is(true));
		
		//Limites inferiores
		assertThat(intervalsApi.isWithinInterval(interval, 0), is(false));
		assertThat(intervalsApi.isWithinInterval(interval, 1), is(true));
		//Limites superiores
		assertThat(intervalsApi.isWithinInterval(interval, 10), is(true));
		assertThat(intervalsApi.isWithinInterval(interval, 11), is(false));
		
	}
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_tipo_derecho_abierto(){
		Interval interval=new Interval(0,10,IntervalType.RIGHT_OPENED);
		assertThat(intervalsApi.isWithinInterval(interval, 7), is(true));
		
//		//Limites inferiores
		assertThat(intervalsApi.isWithinInterval(interval, 0), is(true));
		assertThat(intervalsApi.isWithinInterval(interval, -1), is(false));
//		//Limites superiores
		assertThat(intervalsApi.isWithinInterval(interval, 10), is(false));
		assertThat(intervalsApi.isWithinInterval(interval, 9), is(true));
		
	}
	
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_tipo_cerrado(){
		Interval interval=new Interval(0,10,IntervalType.UNOPENED);
		assertThat(intervalsApi.isWithinInterval(interval, 7), is(true));
		
		//Limites inferiores
		assertThat(intervalsApi.isWithinInterval(interval, 0), is(true));
		assertThat(intervalsApi.isWithinInterval(interval, -1), is(false));
		//Limites superiores
		assertThat(intervalsApi.isWithinInterval(interval, 10), is(true));
		assertThat(intervalsApi.isWithinInterval(interval, 11), is(false));
		
	}
	
	
	@Test
	public void validar_si_hay_esta_incluido_en_un_intervalo(){
		Interval intervalComparador=new Interval(0,10,IntervalType.UNOPENED);
		
		
		Interval intervalUnOpenOK=new Interval(0,10, IntervalType.UNOPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador, intervalUnOpenOK), is(true));
		
		Interval intervalLeftOpenOK=new Interval(0,10, IntervalType.LEFT_OPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador, intervalLeftOpenOK), is(true));

		Interval intervalLeftOpenKO=new Interval(-1,10, IntervalType.LEFT_OPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador,intervalLeftOpenKO), is(false));
		
		Interval intervalUnOpenKOHiger=new Interval(0,10, IntervalType.UNOPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador,intervalUnOpenKOHiger), is(true));
		
		Interval intervalRightOpenOk=new Interval(0,10, IntervalType.RIGHT_OPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador,intervalRightOpenOk), is(true));

		Interval intervalUnOpenKOLower=new Interval(0,11, IntervalType.UNOPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador,intervalUnOpenKOLower), is(false));
		
		Interval intervalRightOpenKOLower=new Interval(0,11, IntervalType.RIGHT_OPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador,intervalRightOpenKOLower), is(false));
		
		Interval intervalRightOpenOKLower=new Interval(0,9, IntervalType.RIGHT_OPENED);
		assertThat(intervalsApi.isIncluidedInterval(intervalComparador,intervalRightOpenOKLower), is(true));
		
	}


	
	

}
