package main.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.coinstorage.CoinStorage;
import main.java.exception.InvalidCoinException;

public class CoinStorageTest {

	private CoinStorage coinStorage;

	@Before
	public void setup() {
		coinStorage = new CoinStorage(2, 2, 2);
	}

	@Test
	public void whenStashCoinsIsGivenAQuarterTheTwentyFiveCentSlotCountIsIncremented() throws InvalidCoinException {
		List<String> testCoins = new ArrayList<String>();
		testCoins.add("quarter");

		coinStorage.stashCoins(testCoins);
		assertEquals(3, coinStorage.getTwentyFiveCentSlot().getCoinCount());
	}

	@Test
	public void whenStashCoinsIsGivenADimeTheTenCentSlotCountIsIncremented() throws InvalidCoinException {
		List<String> testCoins = new ArrayList<String>();
		testCoins.add("dime");

		coinStorage.stashCoins(testCoins);
		assertEquals(3, coinStorage.getTenCentSlot().getCoinCount());
	}

	@Test
	public void whenStashCoinIsGivenANickelTheFiveCentSlotCountIsIncremented() throws InvalidCoinException {
		List<String> testCoins = new ArrayList<String>();
		testCoins.add("nickel");

		coinStorage.stashCoins(testCoins);
		assertEquals(3, coinStorage.getFiveCentSlot().getCoinCount());
	}

	@Test
	public void whenStashCoinIsGivenATwoCoinsTheAppropriateSlotsAreIncremented() throws InvalidCoinException {
		List<String> testCoins = new ArrayList<String>();
		testCoins.add("nickel");
		testCoins.add("dime");

		coinStorage.stashCoins(testCoins);
		assertEquals(3, coinStorage.getFiveCentSlot().getCoinCount());
		assertEquals(3, coinStorage.getTenCentSlot().getCoinCount());
		assertEquals(2, coinStorage.getTwentyFiveCentSlot().getCoinCount());
	}

	@Test(expected = InvalidCoinException.class)
	public void whenStashCoinIsGivenAnUnknownCoinTheCoinStorageThrowsAnException() throws InvalidCoinException {
		List<String> testCoins = new ArrayList<String>();
		testCoins.add("fake coin");

		coinStorage.stashCoins(testCoins);
	}
}
