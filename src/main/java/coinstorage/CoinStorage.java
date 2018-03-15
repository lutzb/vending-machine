package main.java.coinstorage;

import java.util.ArrayList;
import java.util.List;

import main.java.exception.InvalidCoinException;
import main.java.util.Constants;
import main.java.util.VendingMachineUtil;

public class CoinStorage {
	
	private ICoinSlot twentyFiveCentSlot;
	private ICoinSlot tenCentSlot;
	private ICoinSlot fiveCentSlot;
	private int currentChangeDue;
	
	public CoinStorage(int twentyFiveCentCoins, int tenCentCoins, int fiveCentCoins) {
    	this.twentyFiveCentSlot = new TwentyFiveCentSlot(twentyFiveCentCoins);
    	this.tenCentSlot = new TenCentSlot(tenCentCoins);
    	this.fiveCentSlot = new FiveCentSlot(fiveCentCoins);
    	this.currentChangeDue = 0;
	}
	
	public void stashCoins(List<String> coins) throws InvalidCoinException{
		for (String coin : coins) {
			stashCoin(coin);
		}
	}
	
	public boolean ableToMakeChange() {
		// As a safety precaution, VendingMachine will need at least two of each coin to make change
    	return twentyFiveCentSlot.getCoinCount() >= 2 && 
    			tenCentSlot.getCoinCount() >= 2 && 
    			fiveCentSlot.getCoinCount() >= 2;
	}

	public void dispenseChange(int changeDue, ArrayList<String> coinReturn) {
		currentChangeDue = changeDue;
		dispenseCoins(twentyFiveCentSlot, coinReturn);
		dispenseCoins(tenCentSlot, coinReturn);
		dispenseCoins(fiveCentSlot, coinReturn);
	}
	
	private void stashCoin(String customerCoin) throws InvalidCoinException {
		if (customerCoin.equals(Constants.QUARTER)) {
			twentyFiveCentSlot.addCoin();
		} else if (customerCoin.equals(Constants.DIME)) {
			tenCentSlot.addCoin();
		} else if (customerCoin.equals(Constants.NICKEL)) {
			fiveCentSlot.addCoin();
		} else {
			throw new InvalidCoinException(customerCoin);
		}
	}
	
    private void dispenseCoins(ICoinSlot coinSlot, ArrayList<String> coinReturn) {
    	int coinValue = coinSlot.getCoinValue();
    	int coinsDue = VendingMachineUtil.determineNumberOfCoinsDue(coinValue, currentChangeDue);
		
    	for (int i = 0; i < coinsDue; i++) {
			coinSlot.removeCoin();
			coinReturn.add(coinSlot.getCoinName());
			currentChangeDue -= coinValue;
		}
    }

	public ICoinSlot getTwentyFiveCentSlot() {
		return twentyFiveCentSlot;
	}

	public ICoinSlot getTenCentSlot() {
		return tenCentSlot;
	}

	public ICoinSlot getFiveCentSlot() {
		return fiveCentSlot;
	}

}
