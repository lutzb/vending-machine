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
        assertEquals("INSERT COINS", vendingMachine.getDisplayMessage());
    }
    
    @Test
    public void whenUserInsertsANickelTheVendingMachineBalanceIsUpdated() {
    	this.vendingMachine.insertCoin("nickel");
    	
    	assertEquals(0.05, vendingMachine.getBalance());
    }
    
    @Test
    public void whenUserInsertsADimeTheVendingMachineBalanceIsUpdated() {
    	this.vendingMachine.insertCoin("dime");
    	
    	assertEquals(0.10, vendingMachine.getBalance());
    }
    
    @Test
    public void whenUserInsertsAQuarterTheVendingMachineBalanceIsUpdated() {
    	this.vendingMachine.insertCoin("quarter");
    	
    	assertEquals(0.25, vendingMachine.getBalance());
    }
}
