package mma.legacy.interval;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class IntervalScaffoldingTest {	


	
	@Test
	public void calcula_el_punto_medio_de_un_intervalo(){
		Interval interval=new Interval(0,10,IntervalType.BOTH_OPENED);
		assertThat(interval.getMidPoint(), is(5d));
		//Litime  inferior
		assertThat(interval.getMidPoint(), not(4d));
		//limite superior
		assertThat(interval.getMidPoint(), not(6d));
		
	}
	
	
	
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_del_tipo_ambos_abierto(){
		Interval interval=new Interval(0,10,IntervalType.BOTH_OPENED);
		
		assertThat(interval.isWithinInterval(7), is(true));
		//Limites inferiores
		assertThat(interval.isWithinInterval(0), is(false));
		assertThat(interval.isWithinInterval(1), is(true));
		//Limites superiores
		assertThat(interval.isWithinInterval(10), is(false));
		assertThat(interval.isWithinInterval(9), is(true));
		
	}
	
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_tipo_izquierda_abierto(){
		Interval interval=new Interval(0,10,IntervalType.LEFT_OPENED);
		assertThat(interval.isWithinInterval(7), is(true));
		
		//Limites inferiores
		assertThat(interval.isWithinInterval(0), is(false));
		assertThat(interval.isWithinInterval(1), is(true));
		//Limites superiores
		assertThat(interval.isWithinInterval(10), is(true));
		assertThat(interval.isWithinInterval(11), is(false));
		
	}
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_tipo_derecho_abierto(){
		Interval interval=new Interval(0,10,IntervalType.RIGHT_OPENED);
		assertThat(interval.isWithinInterval(7), is(true));
		
		//Limites inferiores
		assertThat(interval.isWithinInterval(0), is(true));
		assertThat(interval.isWithinInterval(-1), is(false));
		//Limites superiores
		assertThat(interval.isWithinInterval(10), is(false));
		assertThat(interval.isWithinInterval(9), is(true));
		
	}
	
	@Test
	public void validar_si_el_valor_esta_dentro_del_intervalo_tipo_cerrado(){
		Interval interval=new Interval(0,10,IntervalType.UNOPENED);
		assertThat(interval.isWithinInterval(7), is(true));
		
		//Limites inferiores
		assertThat(interval.isWithinInterval(0), is(true));
		assertThat(interval.isWithinInterval(-1), is(false));
		//Limites superiores
		assertThat(interval.isWithinInterval(10), is(true));
		assertThat(interval.isWithinInterval(11), is(false));
		
	}
	
	
	@Test
	public void validar_si_hay_esta_incluido_en_un_intervalo(){
		Interval intervalComparador=new Interval(0,10,IntervalType.UNOPENED);
		
	
		Interval intervalUnOpenOK=new Interval(0,10, IntervalType.UNOPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalUnOpenOK), is(true));
		
		Interval intervalLeftOpenOK=new Interval(0,10, IntervalType.LEFT_OPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalLeftOpenOK), is(true));
		//TODO Revisar este caso porque tendria que devolver un true
		Interval intervalLeftOpenKO=new Interval(-1,10, IntervalType.LEFT_OPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalLeftOpenKO), is(false));
		
		Interval intervalUnOpenKOHiger=new Interval(0,10, IntervalType.UNOPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalUnOpenKOHiger), is(true));
		
		Interval intervalRightOpenOk=new Interval(0,10, IntervalType.RIGHT_OPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalRightOpenOk), is(true));

		Interval intervalUnOpenKOLower=new Interval(0,11, IntervalType.UNOPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalUnOpenKOLower), is(false));
		//TODO Revisar este caso porque tendria que devolver un true
		Interval intervalRightOpenKOLower=new Interval(0,11, IntervalType.RIGHT_OPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalRightOpenKOLower), is(false));
		
		Interval intervalRightOpenOKLower=new Interval(0,9, IntervalType.RIGHT_OPENED);
		assertThat(intervalComparador.isIncludedInterval(intervalRightOpenOKLower), is(true));
		
	}

	@Test
	public void myTest(){
		Interval intervalComparador=new Interval(0,10,IntervalType.UNOPENED);
		Interval interval=new Interval(0,10,IntervalType.UNOPENED);
		IntervalsComparator comparator=new IntervalsComparator();
		boolean result=comparator.isIncluidedInterval(intervalComparador,interval);
	}
	
	
	

}
