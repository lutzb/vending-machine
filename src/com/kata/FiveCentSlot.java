package com.kata;

import java.math.BigDecimal;

public class FiveCentSlot implements ICoinSlot {
	
	private BigDecimal coinValue;
	
	private int coinCount;
	
	public FiveCentSlot(int coinCount) {
		this.coinValue = new BigDecimal("0.05");
		this.coinCount = coinCount;
	}
	
	public BigDecimal getCoinValue() {
		return coinValue;
	}
	
	public void addCoin() {
		coinCount++;
	}
	
	public void removeCoin() {
		coinCount--;
	}

	public int getCoinCount() {
		return coinCount;
	}
}
