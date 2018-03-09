package com.coinslot;

import java.math.BigDecimal;

import com.util.Constants;

public class TenCentSlot implements ICoinSlot {

	private String coinName;
	
	private BigDecimal coinValue;
	
	private int coinCount;
	
	public TenCentSlot(int coinCount) {
		this.coinName = Constants.DIME;
		this.coinValue = new BigDecimal(Constants.TEN_CENTS);
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
