import java.math.BigDecimal;
import java.util.ArrayList;

public class VendingMachine {
	
	private BigDecimal balance;
	
	private ArrayList<String> coinReturn;
	
	private IProduct productReturn;
	
	private String display;

    public VendingMachine() {
    	this.balance = new BigDecimal("0.0");
    	this.coinReturn = new ArrayList<String>();
    	this.productReturn = null;
    	this.display = "INSERT COINS";
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
    
    public void pressButton(String productStr) {
    	if (productStr.equals("cola")) {
    		dispenseProduct(new Cola());
    	} else if (productStr.equals("chips")) {
    		dispenseProduct(new Chips());
    	} else if (productStr.equals("candy")) {
    		dispenseProduct(new Candy());
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
    	if (balance.compareTo(productPrice) >= 0) {
    		balance = balance.subtract(productPrice);
			productReturn = product;
			display = "THANK YOU";
			returnChange();
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
    
    public IProduct getProductReturn() {
    	return this.productReturn;
    }
    
    public ArrayList<String> getCoinReturn() {
    	return this.coinReturn;
    }
}
