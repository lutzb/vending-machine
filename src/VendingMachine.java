public class VendingMachine {
	
	private double balance;

    public VendingMachine() {
    	this.balance = 0.0;
    	System.out.println(getDisplayMessage());
    }
    
    public void insertCoin(String coin) {
    	// Assign coin value based on weight
    	if (coin.length() == 6) {  // Hopefully a nickel
    		balance += 0.05;
    	} else if (coin.length() == 4) {  // Hopefully a dime
    		balance += 0.1;
    	}
    }

    public String getDisplayMessage() {
        return "INSERT COINS";
    }
    
    public double getBalance() {
    	return this.balance;
    }
}
