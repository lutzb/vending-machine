package com.kata;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.mutable.MutableInt;

import com.coinslot.FiveCentSlot;
import com.coinslot.ICoinSlot;
import com.coinslot.TenCentSlot;
import com.coinslot.TwentyFiveCentSlot;
import com.product.IProduct;
import com.product.ProductFactory;
import com.util.VendingMachineUtil;

public class VendingMachine {
	
	private BigDecimal customerBalance;
	
	private String display;
	
	private ICoinSlot twentyFiveCentSlot;
	
	private ICoinSlot tenCentSlot;
	
	private ICoinSlot fiveCentSlot;
	
	private ArrayList<String> coinReturn;
	
	private IProduct productReturn;
	
	private Map<String, MutableInt> inventory;

    public VendingMachine(int twentyFiveCentCoins, int tenCentCoins, int fiveCentCoins) {
    	this.twentyFiveCentSlot = new TwentyFiveCentSlot(twentyFiveCentCoins);
    	this.tenCentSlot = new TenCentSlot(tenCentCoins);
    	this.fiveCentSlot = new FiveCentSlot(fiveCentCoins);
    	this.customerBalance = new BigDecimal("0.0");
    	this.coinReturn = new ArrayList<String>();
    	this.productReturn = null;
    	stockInventory();
    	updateDisplay();
    }

	public String checkDisplay() {
    	String currentDisplay = display;
    	updateDisplay();
    	return currentDisplay;
    }
    
    public void insertCoin(String coin) {
    	// Assign coin value based on weight
    	if (coin.length() == 6) {  // Hopefully a nickel worth 5 cents
    		fiveCentSlot.addCoin();
    		customerBalance = customerBalance.add(new BigDecimal("0.05"));
    	} else if (coin.length() == 4) {  // Hopefully a dime worth 10 cents
    		tenCentSlot.addCoin();
    		customerBalance = customerBalance.add(new BigDecimal("0.10"));
    	} else if (coin.length() == 7) {  // Hopefully a quarter worth 25 cents
    		twentyFiveCentSlot.addCoin();
    		customerBalance = customerBalance.add(new BigDecimal("0.25"));
    	} else {
    		coinReturn.add(coin);
    	}
    	
    	updateDisplay();
    }
    
    public void pressProductButton(String buttonPressed) {
    	IProduct product = ProductFactory.getProduct(buttonPressed);
    	
    	if (product != null) {
    		BigDecimal productPrice = product.getPrice();
        	String productType = product.getType();
        	if (customerBalance.compareTo(productPrice) >= 0 && inventory.get(productType).getValue() > 0) {
        		dispenseProduct(product);
    			returnChange();
    		} else if (inventory.get(productType).getValue() == 0) {
    			display = "SOLD OUT";
    		} else {
    			display = "PRICE: $" + VendingMachineUtil.padPriceWithZero(productPrice);
    		}
    		
    	}
    }
    
    public void pressReturnChangeButton() {
		returnChange();
		updateDisplay();
    }
    
    private void dispenseProduct(IProduct product) {
		customerBalance = customerBalance.subtract(product.getPrice());
		inventory.get(product.getType()).decrement();
		productReturn = product;
		display = "THANK YOU";
    }

    private void updateDisplay() {
    	if (customerBalance.compareTo(new BigDecimal("0.0")) > 0) {
    		display = "$" + VendingMachineUtil.padPriceWithZero(customerBalance);
    	} else if (!canMakeChange()) {
    		display = "EXACT CHANGE ONLY";
    	} else {
    		display = "INSERT COINS";
    	}
    }

	private void returnChange() {
		dispenseCoins(twentyFiveCentSlot);
		dispenseCoins(tenCentSlot);
		dispenseCoins(fiveCentSlot);
    }
    
    private void dispenseCoins(ICoinSlot coinSlot) {
    	BigDecimal coinValue = coinSlot.getCoinValue();
    	int coinsDue = VendingMachineUtil.determineNumberOfCoinsDue(coinValue, customerBalance);
		
    	for (int i = 0; i < coinsDue; i++) {
			coinSlot.removeCoin();
			coinReturn.add(coinSlot.getCoinName());
			customerBalance = customerBalance.subtract(coinValue);
		}
	}

	private void stockInventory() {
    	// Vending Machine will hold 2 of each product
    	inventory = new HashMap<String, MutableInt>();
    	inventory.put("cola", new MutableInt(2));
    	inventory.put("chips", new MutableInt(2));
    	inventory.put("candy", new MutableInt(2));
    }
    
    private boolean canMakeChange() {
    	// As a safety precaution, VendingMachine will need at least two of each coin to make change
    	return twentyFiveCentSlot.getCoinCount() >= 2 && 
    			tenCentSlot.getCoinCount() >= 2 && 
    			fiveCentSlot.getCoinCount() >= 2;
	}
    
    public IProduct getProductReturn() {
    	return this.productReturn;
    }
    
    public ArrayList<String> getCoinReturn() {
    	return this.coinReturn;
    }
}
