import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

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
    public void whenAnUnrecognizedCoinIsInsertedVendingMachineReturnsIt() {
    	this.vendingMachine.insertCoin("fake coin");
    	ArrayList<String> coinReturn = this.vendingMachine.getCoinReturn();
    	
    	assertEquals(1, coinReturn.size());
    	assertEquals("fake coin", coinReturn.get(0));
    }
    
    @Test
    public void whenUserInsetsAPennyVendingMachineDisplaysInsertCoinsMessageAndReturnsCoin() {
    	this.vendingMachine.insertCoin("penny");
    	ArrayList<String> coinReturn = this.vendingMachine.getCoinReturn();
    	
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(1, coinReturn.size());
    	assertEquals("penny", coinReturn.get(0));
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
