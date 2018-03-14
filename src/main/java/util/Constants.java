package main.java.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	// Coin names
	public static final String QUARTER = "quarter";
	public static final String DIME = "dime";
	public static final String NICKEL = "nickel";
	
	// Coin values
	public static final int TWENTY_FIVE_CENTS = 25;
	public static final int TEN_CENTS = 10;
	public static final int FIVE_CENTS = 5;
	
	// Products
	public static final String COLA = "cola";
	public static final String CHIPS = "chips";
	public static final String CANDY = "candy";
	
	// Product Prices
	public static final int COLA_PRICE = 100;
	public static final int CANDY_PRICE = 65;
	public static final int CHIPS_PRICE = 50;
	
	// General
	public static final String SOLD_OUT = "SOLD OUT";
	public static final String THANK_YOU = "THANK YOU";
	public static final String EXACT_CHANGE = "EXACT CHANGE ONLY";
	public static final String INSERT_COINS = "INSERT COINS";

	public static final Map<String, Integer> coinValues;
	
	static {
		coinValues = new HashMap<String, Integer>();
		coinValues.put(Constants.QUARTER, Constants.TWENTY_FIVE_CENTS);
		coinValues.put(Constants.DIME, Constants.TEN_CENTS);
		coinValues.put(Constants.NICKEL, Constants.FIVE_CENTS);
	}

}
