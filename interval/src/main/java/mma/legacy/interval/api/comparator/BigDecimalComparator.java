package mma.legacy.interval.api.comparator;

import java.math.BigDecimal;

public class BigDecimalComparator {

	public BigDecimalComparator() {
		
	}

	public boolean isBigerOrEquals(BigDecimal bFrist, BigDecimal bBigOrEquals) {
		if(isBiger(bFrist, bBigOrEquals)||areEquals(bFrist, bBigOrEquals)){
			return true;
		}
		return false;
	}

	public boolean isSmallerOrEquals(BigDecimal bFrist, BigDecimal bSmallOrEquals) {
		if(isSmaller(bFrist, bSmallOrEquals)||areEquals(bFrist, bSmallOrEquals)){
			return true;
		}
		return false;
	}

	public boolean isSmaller(BigDecimal bBig, BigDecimal bSmall) {
		if(bBig.compareTo(bSmall)==1){
			return true;
		}
		return false;
		
	}

	public boolean isBiger(BigDecimal bSmall, BigDecimal bBig) {
		if(bSmall.compareTo(bBig)==-1){
			return true;
		}
		return false;
		
	}

	public boolean areEquals(BigDecimal bigDecimal, BigDecimal bigDecimalEquals) {
		if(bigDecimal.compareTo(bigDecimalEquals)==0){
			return true;
		}
		return false;
	}

}