package main.java;
import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.java.kata.VendingMachine;
import main.java.product.IProduct;

public class VendingMachineTest {

	private VendingMachine vendingMachine;
	
	@Before
	public void setup () {
		// Vending Machine will start with 5 of each coin
		vendingMachine = new VendingMachine(5, 5, 5);
	}
	
	// -------------- checkDisplay() tests -------------- 
	
    @Test
    public void whenNoCoinsAreInsertedVendingMachineDisplaysInsertCoinsMessage() {
        assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsANickelTheVendingMachineDisplaysABalanceOfFiveCents() {
    	vendingMachine.insertCoin("nickel");
    	
    	assertEquals("$0.05", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsADimeTheVendingMachineDisplaysABalanceOfTenCents() {
    	vendingMachine.insertCoin("dime");
    	
    	assertEquals("$0.10", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsAQuarterTheVendingMachineDisplaysABalanceOfTwentyFiveCents() {
    	vendingMachine.insertCoin("quarter");
    	
    	assertEquals("$0.25", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsAQuarterAndADimeTheVendingMachineDisplaysABalanceOfThirtyFiveCents() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("dime");
    	
    	assertEquals("$0.35", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsFourQuartersTheVendingMachineDisplaysABalanceOfOneDollar() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	
    	assertEquals("$1.00", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenVendingMachineCannotMakeChangeForAllProductsItDisplaysExactChangeOnly() {
    	// Initialiaze VendingMachine without any coins
    	vendingMachine = new VendingMachine(0, 0, 0);
    	assertEquals("EXACT CHANGE ONLY", vendingMachine.checkDisplay());
    }
    
	// -------------- getCoinReturn() tests --------------
    
    @Test
    public void whenUserInsertsAnUnrecognizedCoinVendingMachineDisplaysInsertCoinsMessageAndReturnsIt() {
    	vendingMachine.insertCoin("fake coin");
    	ArrayList<String> coinReturn = vendingMachine.getCoinReturn();
    	
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(1, coinReturn.size());
    	assertEquals("fake coin", coinReturn.get(0));
    }
    
    @Test
    public void whenUserInsertsAPennyVendingMachineDisplaysInsertCoinsMessageAndReturnsIt() {
    	vendingMachine.insertCoin("penny");
    	ArrayList<String> coinReturn = vendingMachine.getCoinReturn();
    	
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(1, coinReturn.size());
    	assertEquals("penny", coinReturn.get(0));
    }
    
    @Test
    public void whenUserInsertsMoreQuartersThanTheCostOfChipsVendingMachineReturnsTheUsersChange() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	
    	vendingMachine.pressProductButton("chips");
    	ArrayList<String> coinReturn = vendingMachine.getCoinReturn();
    	
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(2, coinReturn.size());
    	assertEquals("quarter", coinReturn.get(0));
    	assertEquals("quarter", coinReturn.get(1));
    }
    
    @Test
    public void whenUserInsertsAVarietyOfChangeMoreThanTheCostOfChipsVendingMachineReturnsTheUsersChange() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("dime");
    	vendingMachine.insertCoin("nickel");
    	
    	vendingMachine.pressProductButton("chips");
    	ArrayList<String> coinReturn = vendingMachine.getCoinReturn();
    	
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(3, coinReturn.size());
    	assertEquals("quarter", coinReturn.get(0));
    	assertEquals("dime", coinReturn.get(1));
    	assertEquals("nickel", coinReturn.get(2));
    }
    
	// -------------- pressProductButton() tests --------------
    
    @Test
    public void whenUserPressesColaButtonWithoutInsertingAnyMoneyVendingMachineDisplaysThePriceOfColaThenResetsTheDisplay() {
    	vendingMachine.pressProductButton("cola");
    	
    	assertEquals("PRICE: $1.00", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserPressesChipsButtonWithoutInsertingAnyMoneyVendingMachineDisplaysThePriceOfChipsThenResetsTheDisplay() {
    	vendingMachine.pressProductButton("chips");
    	
    	assertEquals("PRICE: $0.50", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserPressesCandyButtonWithoutInsertingAnyMoneyVendingMachineDisplaysThePriceOfCandyThenResetsTheDisplay() {
    	vendingMachine.pressProductButton("candy");
    	
    	assertEquals("PRICE: $0.65", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsExactChangeAndPressesColaButtonVendingMachineDispensesCola() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	
    	vendingMachine.pressProductButton("cola");
    	
    	IProduct productReturn = vendingMachine.getProductReturn();
    	assertEquals("cola", productReturn.getType());
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsExactChangeAndPressesChipsButtonVendingMachineDispensesChips() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	
    	vendingMachine.pressProductButton("chips");
    	
    	IProduct productReturn = vendingMachine.getProductReturn();
    	assertEquals("chips", productReturn.getType());
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserInsertsExactChangeAndPressesCandyButtonVendingMachineDispensesCandy() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("dime");
    	vendingMachine.insertCoin("nickel");
    	
    	vendingMachine.pressProductButton("candy");
    	
    	IProduct productReturn = vendingMachine.getProductReturn();
    	assertEquals("candy", productReturn.getType());
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    @Test
    public void whenUserBuysAllTheInventoryOfColaVendingMachineDisplaysOutOfStock() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
  
    	vendingMachine.pressProductButton("cola");
    	
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	
    	vendingMachine.pressProductButton("cola");
    	
    	assertEquals("THANK YOU", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	
    	vendingMachine.pressProductButton("cola");
    	
    	assertEquals("SOLD OUT", vendingMachine.checkDisplay());
    	assertEquals("$1.00", vendingMachine.checkDisplay());
    	
    }
    
    @Test
    public void whenUserPressesAnInvalidProductButtonTheDisplayShowsInvalidProduct() {
    	vendingMachine.pressProductButton("meatballs");
    	
    	assertEquals("INVALID PRODUCT", vendingMachine.checkDisplay());
    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    }
    
    // -------------- pressReturnChangeButton() tests --------------
    
    @Test
    public void whenUserInsertsThreeDimesThenPressesReturnChangeButtonVendingMachineReturnsTheUsersChange() {
    	vendingMachine.insertCoin("dime");
    	vendingMachine.insertCoin("dime");
    	vendingMachine.insertCoin("dime");
    	
    	vendingMachine.pressReturnChangeButton();
    	
    	ArrayList<String> coinReturn = vendingMachine.getCoinReturn();

    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(3, coinReturn.size());
    	assertEquals("dime", coinReturn.get(0));
    	assertEquals("dime", coinReturn.get(1));
    	assertEquals("dime", coinReturn.get(2));
    }
    
    @Test
    public void whenUserInsertsCoinsThenPressesReturnChangeButtonVendingMachineReturnsTheUsersChange() {
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("quarter");
    	vendingMachine.insertCoin("dime");
    	vendingMachine.insertCoin("dime");
    	vendingMachine.insertCoin("dime");
    	vendingMachine.insertCoin("nickel");
    	vendingMachine.insertCoin("nickel");
    	
    	vendingMachine.pressReturnChangeButton();
    	
    	ArrayList<String> coinReturn = vendingMachine.getCoinReturn();

    	assertEquals("INSERT COINS", vendingMachine.checkDisplay());
    	assertEquals(7, coinReturn.size());
    	assertEquals("quarter", coinReturn.get(0));
    	assertEquals("quarter", coinReturn.get(1));
    	assertEquals("dime", coinReturn.get(2));
    	assertEquals("dime", coinReturn.get(3));
    	assertEquals("dime", coinReturn.get(4));
    	assertEquals("nickel", coinReturn.get(5));
    	assertEquals("nickel", coinReturn.get(6));
    }
}
