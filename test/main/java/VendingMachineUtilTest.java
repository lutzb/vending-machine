package main.java;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import main.java.util.VendingMachineUtil;

public class VendingMachineUtilTest {

	@Test
	public void whenConvertCentsToDollarStringIsGiven5CentsItReturnsTheCorrectString() {
		assertEquals("0.05", VendingMachineUtil.centsToDollars(5));
	}

	@Test
	public void whenConvertCentsToDollarStringIsGiven10CentsItReturnsTheCorrectString() {
		assertEquals("0.15", VendingMachineUtil.centsToDollars(15));
	}

	@Test
	public void whenConvertCentsToDollarStringIsGiven15CentsItReturnsTheCorrectString() {
		assertEquals("0.50", VendingMachineUtil.centsToDollars(50));
	}

	@Test
	public void whenConvertCentsToDollarStringIsGiven100CentsItReturnsTheCorrectString() {
		assertEquals("1.00", VendingMachineUtil.centsToDollars(100));
	}

	@Test
	public void whenDetermineNumberOfCoinsDueIsGivenA50CentsBalanceAnd25CentsValueItReturns2() {
		assertEquals(2, VendingMachineUtil.determineNumberOfCoinsDue(25, 50));
	}

	@Test
	public void whenDetermineNumberOfCoinsDueIsGivenA50CentsBalanceAnd10CentsValueItReturns5() {
		assertEquals(5, VendingMachineUtil.determineNumberOfCoinsDue(10, 50));
	}

	@Test
	public void whenDetermineNumberOfCoinsDueIsGivenA50CentsBalanceAnd5CentsValueItReturns10() {
		assertEquals(10, VendingMachineUtil.determineNumberOfCoinsDue(5, 50));
	}

	@Test
	public void whenDetermineNumberOfCoinsDueIsGivenA65CentsBalanceAnd25CentsItReturns2() {
		assertEquals(2, VendingMachineUtil.determineNumberOfCoinsDue(25, 65));
	}

	@Test
	public void whenDetermineNumberOfCoinsDueIsGivenA65CentsBalanceAnd5CentsItReturns13() {
		assertEquals(13, VendingMachineUtil.determineNumberOfCoinsDue(5, 65));
	}

}
