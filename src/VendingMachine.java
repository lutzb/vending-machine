import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.mutable.MutableInt;

public class VendingMachine {
	
	private BigDecimal balance;
	
	private String display;
	
	private ArrayList<String> coinReturn;
	
	private IProduct productReturn;
	
	private Map<String, MutableInt> inventory;

    public VendingMachine() {
    	this.balance = new BigDecimal("0.0");
    	this.display = "INSERT COINS";
    	this.coinReturn = new ArrayList<String>();
    	this.productReturn = null;
    	stockInventory();
    }
    
    public String checkDisplay() {
    	String currentDisplay = display;
    	updateDisplay();
    	return currentDisplay;
    }
    
    public void insertCoin(String coin) {
    	// Assign coin value based on weight
    	if (coin.length() == 6) {  // Hopefully a nickel
    		balance = balance.add(new BigDecimal("0.05"));
    	} else if (coin.length() == 4) {  // Hopefully a dime
    		balance = balance.add(new BigDecimal("0.10"));
    	} else if (coin.length() == 7) {  // Hopefully a quarter
    		balance = balance.add(new BigDecimal("0.25"));
    	} else {
    		coinReturn.add(coin);
    	}
    	
    	updateDisplay();
    }
    
    public void pressButton(String buttonPressed) {
    	if (buttonPressed.equals("cola")) {
    		dispenseProduct(new Cola());
    	} else if (buttonPressed.equals("chips")) {
    		dispenseProduct(new Chips());
    	} else if (buttonPressed.equals("candy")) {
    		dispenseProduct(new Candy());
    	} else if (buttonPressed.equals("returnChange")) {
    		returnChange();
    		updateDisplay();
    	}
    }

	protected String padPriceWithZero(BigDecimal price) {
    	String priceStr = String.valueOf(price);
    	// Check number of decimal places
		int indexOfDecimal = priceStr.indexOf(".");
		String decimalPlaces = priceStr.substring(indexOfDecimal + 1);
		
		// Add a '0' to the end of the display if balance only has one decimal place
		if (decimalPlaces.length() < 2) {
			priceStr += "0";
		}
		
		return priceStr;
    }
    
    private void dispenseProduct(IProduct product) {
    	BigDecimal productPrice = product.getPrice();
    	String productType = product.getType();
    	if (balance.compareTo(productPrice) >= 0 && inventory.get(productType).getValue() > 0) {
    		balance = balance.subtract(productPrice);
    		inventory.get(productType).decrement();
			productReturn = product;
			display = "THANK YOU";
			returnChange();
		} else if (inventory.get(productType).getValue() == 0) {
			display = "SOLD OUT";
		} else {
			display = "PRICE: $" + padPriceWithZero(productPrice);
		}
    }

    private void updateDisplay() {
    	if (balance.compareTo(new BigDecimal("0.0")) == 0) {
    		display = "INSERT COINS";
    	} else {
    		display = "$" + padPriceWithZero(balance);
    	}
    }
    
    private void returnChange() {
    	while (balance.compareTo(new BigDecimal("0.25")) >= 0) {
    		coinReturn.add("quarter");
    		balance = balance.subtract(new BigDecimal("0.25"));
    	}
    	while (balance.compareTo(new BigDecimal("0.10")) >= 0) {
    		coinReturn.add("dime");
    		balance = balance.subtract(new BigDecimal("0.10"));
    	}
    	while (balance.compareTo(new BigDecimal("0.05")) >= 0) {
    		coinReturn.add("nickel");
    		balance = balance.subtract(new BigDecimal("0.05"));
    	}
    }
    
    private void stockInventory() {
    	// Vending Machine will hold 2 of each product
    	inventory = new HashMap<String, MutableInt>();
    	inventory.put("cola", new MutableInt(2));
    	inventory.put("chips", new MutableInt(2));
    	inventory.put("candy", new MutableInt(2));
    }
    
    public IProduct getProductReturn() {
    	return this.productReturn;
    }
    
    public ArrayList<String> getCoinReturn() {
    	return this.coinReturn;
    }
}
