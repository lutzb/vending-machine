package com.coinslot;

import java.math.BigDecimal;

import com.util.Constants;

public class FiveCentSlot implements ICoinSlot {
	
	private String coinName;
	
	private BigDecimal coinValue;
	
	private int coinCount;
	
	public FiveCentSlot(int coinCount) {
		this.coinName = Constants.NICKEL;
		this.coinValue = new BigDecimal(Constants.FIVE_CENTS);
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
