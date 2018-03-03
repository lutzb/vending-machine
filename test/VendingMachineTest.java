import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {

	private VendingMachine vendingMachine;
	
	@Before
	public void setup () {
		this.vendingMachine = new VendingMachine();
	}
	
    @Test
    public void whenNoCoinsAreInsertedVendingMachineDisplaysInsertCoinsMessage() {
        assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsetsAPennyVendingMachineDisplaysInsertCoinsMessage() {
    	this.vendingMachine.insertCoin("penny");
    	
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsANickelTheVendingMachineBalanceIsUpdatedToFiveCents() {
    	this.vendingMachine.insertCoin("nickel");
    	
    	assertEquals("$0.05", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsADimeTheVendingMachineBalanceIsUpdatedToTenCents() {
    	this.vendingMachine.insertCoin("dime");
    	
    	assertEquals("$0.10", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsAQuarterTheVendingMachineBalanceIsUpdatedToTwentyFiveCents() {
    	this.vendingMachine.insertCoin("quarter");
    	
    	assertEquals("$0.25", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsAQuarterAndDimeTheVendingMachineBalanceIsUpdatedToThirtyFiveCents() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("dime");
    	
    	assertEquals("$0.35", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsFourQuartersTheVendingMachineBalanceIsUpdatedToOneDollar() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	
    	assertEquals("$1.00", vendingMachine.checkDisplay());
    }
}
