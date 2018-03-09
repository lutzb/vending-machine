package com.kata;

import java.math.BigDecimal;

public class FiveCentSlot implements ICoinSlot {
	
	private String coinName;
	
	private BigDecimal coinValue;
	
	private int coinCount;
	
	public FiveCentSlot(int coinCount) {
		this.coinName = "nickel";
		this.coinValue = new BigDecimal("0.05");
		this.coinCount = coinCount;
	}
	
	public String getCoinName() {
		return coinName;
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
