import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineProductsTest {
	
	private VendingMachine vendingMachine;
	
	@Before
	public void setup () {
		this.vendingMachine = new VendingMachine();
	}
	
    @Test
    public void whenUserTriesToBuyColaWithoutInsertingAnyMoneyVendingMachineReturnsThePriceOfCola() {
    	this.vendingMachine.pressButton("cola");
    	
    	assertEquals("PRICE: $1.00", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsCoinsAndBuysColaWithExactChangeThenColaIsDispensed() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	
    	this.vendingMachine.pressButton("cola");
    	
    	ArrayList<IProduct> productReturn = this.vendingMachine.getProductReturn();
    	assertEquals(1, productReturn.size());
    	assertEquals("cola", productReturn.get(0).getType());
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }

}
