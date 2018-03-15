package main.java.kata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.mutable.MutableInt;

import main.java.coinstorage.CoinStorage;
import main.java.exception.InvalidCoinException;
import main.java.exception.InvalidProductException;
import main.java.product.IProduct;
import main.java.product.ProductFactory;
import main.java.util.Constants;
import main.java.util.VendingMachineUtil;

public class VendingMachine {
	
	private String display;
	private int customerBalance;
	private CoinStorage coinStorage;
	private ArrayList<String> customerCoins;
	private ArrayList<String> coinReturn;
	private IProduct productReturn;
	private Map<String, MutableInt> inventory;

    public VendingMachine(int twentyFiveCentCoins, int tenCentCoins, int fiveCentCoins) {
    	this.coinStorage = new CoinStorage(twentyFiveCentCoins, tenCentCoins, fiveCentCoins);
    	this.customerBalance = 0;
    	this.customerCoins = new ArrayList<String>();
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
    	Optional<Integer> coinValue = Optional.ofNullable(Constants.coinValues.get(coin));
    	
    	if (coinValue.isPresent()) {
    		customerCoins.add(coin);
    		customerBalance += coinValue.get();
    	} else {
    		coinReturn.add(coin);
    	}
    	
    	updateDisplay();
    }
    
    public void pressProductButton(String buttonPressed) {
    	try {
    		IProduct product = ProductFactory.getProduct(buttonPressed);

        	if (ableToDispenseProduct(product)) {
        		dispenseProduct(product);
        		moveCustomerCoinsToStorage();
        		coinStorage.dispenseChange(customerBalance, coinReturn);
        		customerBalance = 0;
    		} else if (inventory.get(product.getType()).getValue() == 0) {
    			display = Constants.SOLD_OUT;
    		} else {
    			display = "PRICE: $" + VendingMachineUtil.centsToDollars(product.getPrice());
    		}
    	} catch (InvalidProductException e) {
    		display = "INVALID PRODUCT";
    	}
    }

	public void pressReturnChangeButton() {
		coinReturn = new ArrayList<String>(customerCoins);
		customerCoins.clear();
		customerBalance = 0;
		updateDisplay();
    }
    
    private void dispenseProduct(IProduct product) {
		customerBalance -= product.getPrice();
		inventory.get(product.getType()).decrement();
		productReturn = product;
		display = Constants.THANK_YOU;
    }
    
	private void moveCustomerCoinsToStorage() {
		try {
			coinStorage.stashCoins(customerCoins);
			customerCoins.clear();
		} catch (InvalidCoinException e) {
			display = "INTERNAL ERROR";
		}
	}

    private void updateDisplay() {
    	if (customerBalance != 0) {
    		display = "$" + VendingMachineUtil.centsToDollars(customerBalance);
    	} else if (!coinStorage.ableToMakeChange()) {
    		display = Constants.EXACT_CHANGE;
    	} else {
    		display = Constants.INSERT_COINS;
    	}
    }

	private void stockInventory() {
    	// Vending Machine will hold 2 of each product
    	inventory = new HashMap<String, MutableInt>();
    	inventory.put(Constants.COLA, new MutableInt(2));
    	inventory.put(Constants.CHIPS, new MutableInt(2));
    	inventory.put(Constants.CANDY, new MutableInt(2));
    }
	
    private boolean ableToDispenseProduct(IProduct product) {
    	return customerBalance >= product.getPrice() && inventory.get(product.getType()).getValue() > 0;
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
