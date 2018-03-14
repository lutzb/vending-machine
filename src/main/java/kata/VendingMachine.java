package main.java.kata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
	
	private String display;
	private int customerBalance;
	private ICoinSlot twentyFiveCentSlot;
	private ICoinSlot tenCentSlot;
	private ICoinSlot fiveCentSlot;
	private ArrayList<String> customerCoins;
	private ArrayList<String> coinReturn;
	private IProduct productReturn;
	private Map<String, MutableInt> inventory;

    public VendingMachine(int twentyFiveCentCoins, int tenCentCoins, int fiveCentCoins) {
    	this.twentyFiveCentSlot = new TwentyFiveCentSlot(twentyFiveCentCoins);
    	this.tenCentSlot = new TenCentSlot(tenCentCoins);
    	this.fiveCentSlot = new FiveCentSlot(fiveCentCoins);
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
        		moveCustomerCoinsToCoinSlots();
    			returnChange();
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
    
	private void moveCustomerCoinsToCoinSlots() {
		for (String customerCoin : customerCoins) {
			if (customerCoin.equals(Constants.QUARTER)) {
				twentyFiveCentSlot.addCoin();
			} else if (customerCoin.equals(Constants.DIME)) {
				tenCentSlot.addCoin();
			} else if (customerCoin.equals(Constants.NICKEL)) {
				fiveCentSlot.addCoin();
			}
		}
		
		customerCoins.clear();
	}

    private void updateDisplay() {
    	if (customerBalance != 0) {
    		display = "$" + VendingMachineUtil.centsToDollars(customerBalance);
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
    	int coinValue = coinSlot.getCoinValue();
    	int coinsDue = VendingMachineUtil.determineNumberOfCoinsDue(coinValue, customerBalance);
		
    	for (int i = 0; i < coinsDue; i++) {
			coinSlot.removeCoin();
			coinReturn.add(coinSlot.getCoinName());
			customerBalance -= coinValue;
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
