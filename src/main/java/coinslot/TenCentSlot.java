package main.java.coinslot;

import main.java.util.Constants;

public class TenCentSlot implements ICoinSlot {

	private String coinName;
	private int coinValue;
	private int coinCount;
	
	public TenCentSlot(int coinCount) {
		this.coinName = Constants.DIME;
		this.coinValue = Constants.TEN_CENTS;
		this.coinCount = coinCount;
	}
	
	public String getCoinName() {
		return coinName;
	}
	
	public int getCoinValue() {
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
