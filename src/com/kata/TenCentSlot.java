package com.kata;

import java.math.BigDecimal;

public class TenCentSlot implements ICoinSlot {

	private BigDecimal coinValue;
	
	private int coinCount;
	
	public TenCentSlot(int coinCount) {
		this.coinValue = new BigDecimal("0.10");
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
