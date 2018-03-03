import java.util.ArrayList;

public class VendingMachine {
	
	private double balance;
	
	private ArrayList<String> coinReturn;
	
	private IProduct productReturn;
	
	private String display;

    public VendingMachine() {
    	this.balance = 0.0;
    	this.coinReturn = new ArrayList<String>();
    	this.productReturn = null;
    	this.display = "INSERT COINS";
    }
    
    public void insertCoin(String coin) {
    	// Assign coin value based on weight
    	if (coin.length() == 6) {  // Hopefully a nickel
    		balance += 0.05;
    	} else if (coin.length() == 4) {  // Hopefully a dime
    		balance += 0.1;
    	} else if (coin.length() == 7) {  // Hopefully a quarter
    		balance += 0.25;
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
    	
    	returnChange();
    }

	protected String padPriceWithZero(Double price) {
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
    	double price = product.getPrice();
    	if (this.balance >= price) {
			this.balance -= price;
			this.productReturn = product;
			this.display = "THANK YOU";
		} else {
			this.display = "PRICE: $" + padPriceWithZero(price);
		}
    }

    private void updateDisplay() {
    	if (this.balance == 0.0) {
    		this.display = "INSERT COINS";
    	} else {
    		this.display = "$" + padPriceWithZero(this.balance);
    	}
    }
    
    private void returnChange() {
    	while (this.balance >= 0.25) {
    		coinReturn.add("quarter");
    		this.balance -= 0.25;
    	}
	}
    
    public IProduct getProductReturn() {
    	return this.productReturn;
    }
    
    public ArrayList<String> getCoinReturn() {
    	return this.coinReturn;
    }
    
    public String checkDisplay() {
    	String current = this.display;
    	updateDisplay();
    	return current;
    }
}
