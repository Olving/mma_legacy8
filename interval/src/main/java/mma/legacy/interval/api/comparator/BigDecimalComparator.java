package mma.legacy.interval.api.comparator;

import java.math.BigDecimal;

/**
 * Esta clase facilita la comparación de  BigDecimals.
 * @author JosepPC
 *
 */
public class BigDecimalComparator {

	public BigDecimalComparator() {
		
	}
	/**
	 * Calcula si  bBigOrEquals es mayor o igual que bFrist
	 * @param bFrist
	 * @param bBigOrEquals
	 * @return boolean
	 */
	public boolean isBigerOrEquals(BigDecimal bFrist, BigDecimal bBigOrEquals) {
		if(isBiger(bFrist, bBigOrEquals)||areEquals(bFrist, bBigOrEquals)){
			return true;
		}
		return false;
	}
	
	/**
	 * Calcula si  bSmallOrEquals es menor o igual que bFrist
	 * @param bFrist
	 * @param bSmallOrEquals
	 * @return boolean
	 */
	public boolean isSmallerOrEquals(BigDecimal bFrist, BigDecimal bSmallOrEquals) {
		if(isSmaller(bFrist, bSmallOrEquals)||areEquals(bFrist, bSmallOrEquals)){
			return true;
		}
		return false;
	}

	/**
	 * Calcula si  bSmall es menor  que bBig
	 * @param bBig
	 * @param bSmallOrEquals
	 * @return boolean
	 */
	public boolean isSmaller(BigDecimal bBig, BigDecimal bSmall) {
		if(bBig.compareTo(bSmall)>0){
			return true;
		}
		return false;
		
	}
	
	/**
	 * Calcula si  bSmall es mayor que bBig
	 * @param bSmall
	 * @param bBig
	 * @return boolean
	 */
	public boolean isBiger(BigDecimal bSmall, BigDecimal bBig) {
		if(bSmall.compareTo(bBig)<0){
			return true;
		}
		return false;
		
	}
	/**
	 * Calcula si  bigDecimal es igual que bigDecimalEquals
	 * @param bigDecimal
	 * @param bigDecimalEquals
	 * @return boolean
	 */
	public boolean areEquals(BigDecimal bigDecimal, BigDecimal bigDecimalEquals) {
		if(bigDecimal.compareTo(bigDecimalEquals)==0){
			return true;
		}
		return false;
	}

}