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
    		IProduct cola = new Cola();
    		
    		if (this.balance >= cola.getPrice()) {
    			this.balance -= cola.getPrice();
    			this.productReturn = cola;
    			this.display = "THANK YOU";
    		} else {
    			this.display = "PRICE: $1.00";
    		}
    	}
    }

    private void updateDisplay() {
    	if (balance == 0.0) {
    		this.display = "INSERT COINS";
    	} else {
    		String balanceStr = String.valueOf(this.balance);
    		
    		// Check number of decimal places
    		int indexOfDecimal = balanceStr.indexOf(".");
    		String decimalPlaces = balanceStr.substring(indexOfDecimal + 1);
    		
    		// Add a '0' to the end of the display if balance only has one decimal place
    		if (decimalPlaces.length() < 2) {
    			balanceStr += "0";
    		}
    		this.display = "$" + balanceStr;
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
