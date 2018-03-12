package main.java.kata;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.mutable.MutableInt;

import main.java.coinslot.FiveCentSlot;
import main.java.coinslot.ICoinSlot;
import main.java.coinslot.TenCentSlot;
import main.java.coinslot.TwentyFiveCentSlot;
import main.java.exception.InvalidProductException;
import main.java.product.IProduct;
import main.java.product.ProductFactory;
import main.java.util.Constants;
import main.java.util.VendingMachineUtil;

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
    	this.customerBalance = new BigDecimal(Constants.ZERO);
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
    		customerBalance = customerBalance.add(new BigDecimal(Constants.FIVE_CENTS));
    	} else if (coin.length() == 4) {  // Hopefully a dime worth 10 cents
    		tenCentSlot.addCoin();
    		customerBalance = customerBalance.add(new BigDecimal(Constants.TEN_CENTS));
    	} else if (coin.length() == 7) {  // Hopefully a quarter worth 25 cents
    		twentyFiveCentSlot.addCoin();
    		customerBalance = customerBalance.add(new BigDecimal(Constants.TWENTY_FIVE_CENTS));
    	} else {
    		coinReturn.add(coin);
    	}
    	
    	updateDisplay();
    }
    
    public void pressProductButton(String buttonPressed) {
    	try {
    		IProduct product = ProductFactory.getProduct(buttonPressed);
    		
    		BigDecimal productPrice = product.getPrice();
        	String productType = product.getType();
        	if (customerBalance.compareTo(productPrice) >= 0 && inventory.get(productType).getValue() > 0) {
        		dispenseProduct(product);
    			returnChange();
    		} else if (inventory.get(productType).getValue() == 0) {
    			display = Constants.SOLD_OUT;
    		} else {
    			display = "PRICE: $" + VendingMachineUtil.padPriceWithZero(productPrice);
    		}
    	} catch (InvalidProductException e) {
    		display = "INVALID PRODUCT";
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
		display = Constants.THANK_YOU;
    }

    private void updateDisplay() {
    	if (customerBalance.compareTo(new BigDecimal(Constants.ZERO)) > 0) {
    		display = "$" + VendingMachineUtil.padPriceWithZero(customerBalance);
    	} else if (!ableToMakeChange()) {
    		display = Constants.EXACT_CHANGE;
    	} else {
    		display = Constants.INSERT_COINS;
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
    	inventory.put(Constants.COLA, new MutableInt(2));
    	inventory.put(Constants.CHIPS, new MutableInt(2));
    	inventory.put(Constants.CANDY, new MutableInt(2));
    }
    
    private boolean ableToMakeChange() {
    	// As a safety precaution, VendingMachine will need at least two of each coin to make change
    	return twentyFiveCentSlot.getCoinCount() >= 2 && 
    			tenCentSlot.getCoinCount() >= 2 && 
    			fiveCentSlot.getCoinCount() >= 2;
	}
    
    public void clearProductReturn() {
    	productReturn = null;
    }
    
    public IProduct getProductReturn() {
    	return productReturn;
    }
    
    public ArrayList<String> getCoinReturn() {
    	return coinReturn;
    }
    
    public void clearCoinReturn() {
    	coinReturn.clear();
    }
}
