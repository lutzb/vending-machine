public class VendingMachine {
	
	private double balance;

    public VendingMachine() {
    	this.balance = 0.0;
    	System.out.println(checkDisplay());
    }
    
    public void insertCoin(String coin) {
    	// Assign coin value based on weight
    	if (coin.length() == 6) {  // Hopefully a nickel
    		balance += 0.05;
    	} else if (coin.length() == 4) {  // Hopefully a dime
    		balance += 0.1;
    	} else if (coin.length() == 7) {  // Hopefully a quarter
    		balance += 0.25;
    	}
    }

    public String checkDisplay() {
    	if (balance == 0.0) {
    		return "INSERT COINS";	
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
}
