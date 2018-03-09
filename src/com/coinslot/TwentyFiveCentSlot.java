package com.coinslot;

import java.math.BigDecimal;

public class TwentyFiveCentSlot implements ICoinSlot {

	private String coinName;
	
	private BigDecimal coinValue;
	
	private int coinCount;
	
	public TwentyFiveCentSlot(int coinCount) {
		this.coinName = "quarter";
		this.coinValue = new BigDecimal("0.25");
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
