public class VendingMachine {
	
	private double balance;

    public VendingMachine() { 
    	this.balance = 0.0;
    }
    
    public void insertCoin(String coin) {
    	// Check if coin of value 0.05 was inserted (nickel)
    	if (coin.length() == 6) {
    		balance += 0.05;
    	}
    }

    public String getDisplayMessage() {
        return "INSERT COINS";
    }
    
    public double getBalance() {
    	return this.balance;
    }
}
