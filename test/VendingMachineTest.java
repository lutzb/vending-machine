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
	
	// -------------- checkDisplay() tests -------------- 
	
    @Test
    public void whenNoCoinsAreInsertedVendingMachineDisplaysInsertCoinsMessage() {
        assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsANickelTheVendingMachineDisplaysABalanceOfFiveCents() {
    	this.vendingMachine.insertCoin("nickel");
    	
    	assertEquals("$0.05", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsADimeTheVendingMachineDisplaysABalanceOfTenCents() {
    	this.vendingMachine.insertCoin("dime");
    	
    	assertEquals("$0.10", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsAQuarterTheVendingMachineDisplaysABalanceOfTwentyFiveCents() {
    	this.vendingMachine.insertCoin("quarter");
    	
    	assertEquals("$0.25", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsAQuarterAndADimeTheVendingMachineDisplaysABalanceOfThirtyFiveCents() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("dime");
    	
    	assertEquals("$0.35", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsFourQuartersTheVendingMachineDisplaysABalanceOfOneDollar() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	
    	assertEquals("$1.00", vendingMachine.checkDisplay());
    }
    
	// -------------- getCoinReturn() tests --------------
    
    @Test
    public void whenUserInsertsAnUnrecognizedCoinVendingMachineDisplaysInsertCoinsMessageAndReturnsIt() {
    	this.vendingMachine.insertCoin("fake coin");
    	ArrayList<String> coinReturn = this.vendingMachine.getCoinReturn();
    	
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(1, coinReturn.size());
    	assertEquals("fake coin", coinReturn.get(0));
    }
    
    @Test
    public void whenUserInsetsAPennyVendingMachineDisplaysInsertCoinsMessageAndReturnsIt() {
    	this.vendingMachine.insertCoin("penny");
    	ArrayList<String> coinReturn = this.vendingMachine.getCoinReturn();
    	
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(1, coinReturn.size());
    	assertEquals("penny", coinReturn.get(0));
    }
    
	// -------------- pressButton() tests --------------
    
    @Test
    public void whenUserPressesColaButtonWithoutInsertingAnyMoneyVendingMachineDisplaysThePriceOfColaThenResetsTheDisplay() {
    	this.vendingMachine.pressButton("cola");
    	
    	assertEquals("PRICE: $1.00", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserPressesChipsButtonWithoutInsertingAnyMoneyVendingMachineDisplaysThePriceOfChipsThenResetsTheDisplay() {
    	this.vendingMachine.pressButton("chips");
    	
    	assertEquals("PRICE: $0.50", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserPressesCandyButtonWithoutInsertingAnyMoneyVendingMachineDisplaysThePriceOfCandyThenResetsTheDisplay() {
    	this.vendingMachine.pressButton("candy");
    	
    	assertEquals("PRICE: $0.65", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsExactChangeAndPressesColaButtonVendingMachineDispensesCola() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	
    	this.vendingMachine.pressButton("cola");
    	
    	IProduct productReturn = this.vendingMachine.getProductReturn();
    	assertEquals("cola", productReturn.getType());
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsExactChangeAndPressesChipsButtonVendingMachineDispensesChips() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	
    	this.vendingMachine.pressButton("chips");
    	
    	IProduct productReturn = this.vendingMachine.getProductReturn();
    	assertEquals("chips", productReturn.getType());
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsExactChangeAndPressesCandyButtonVendingMachineDispensesCandy() {
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("quarter");
    	this.vendingMachine.insertCoin("dime");
    	this.vendingMachine.insertCoin("nickel");
    	
    	this.vendingMachine.pressButton("candy");
    	
    	IProduct productReturn = this.vendingMachine.getProductReturn();
    	assertEquals("candy", productReturn.getType());
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    // -------------- padPriceWithZero() tests -------------- 
    
    @Test
    public void whenPadPriceWithZeroIsGivenADoubleDigitValueItReturnsThatValue() {
    	assertEquals("0.15", vendingMachine.padPriceWithZero(0.15));
    }
    
    @Test
    public void whenPadPriceWithZeroIsGivenASingleDigitValueItReturnsThatValuePaddedWithAZero() {
    	assertEquals("0.10", vendingMachine.padPriceWithZero(0.1));
    }
}
