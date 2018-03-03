import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {

    @Test
    public void whenNoCoinsAreInsertedVendingMachineDisplaysInsertCoinsMessage() {
        VendingMachine vendingMachine = new VendingMachine();

        assertEquals("INSERT COINS", vendingMachine.getDisplayMessage());
    }
    
    @Test
    public void whenUserInsertsANickleVendingMachineBalanceIsUpdated() {
    	VendingMachine vendingMachine = new VendingMachine();
    	vendingMachine.insertCoin("nickel");
    	
    	assertEquals(0.05, vendingMachine.getBalance());
    }
}
