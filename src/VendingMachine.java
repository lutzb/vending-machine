import java.util.ArrayList;

public class VendingMachine {
	
	private double balance;
	
	private ArrayList<String> coinReturn;
	
	private boolean buttonPressed;

    public VendingMachine() {
    	this.balance = 0.0;
    	this.coinReturn = new ArrayList<String>();
    	this.buttonPressed = false;
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
    }

    public String checkDisplay() {
    	if (balance == 0.0 && !buttonPressed) {
    		return "INSERT COINS";	
    	} else if (buttonPressed) {
    		this.buttonPressed = false;
    		return "PRICE: $1.00";
    		
    	} else {
    		String balanceStr = String.valueOf(this.balance);
    		
    		// Check number of decimal places
    		int indexOfDecimal = balanceStr.indexOf(".");
    		String decimalPlaces = balanceStr.substring(indexOfDecimal + 1);
    		
    		// Add a '0' to the end of the display if balance only has one decimal place
    		if (decimalPlaces.length() < 2) {
    			balanceStr += "0";
    		}
    		return "$" + balanceStr;
    	}
    }
    
    public void pressButton(String productStr) {
    	this.buttonPressed = true;
    }
    
    public ArrayList<String> getCoinReturn() {
    	return this.coinReturn;
    }
}
