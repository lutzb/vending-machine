package main.java.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	// Coin names
	public static final String QUARTER = "quarter";
	public static final String DIME = "dime";
	public static final String NICKEL = "nickel";
	
	// Coin values
	public static final String TWENTY_FIVE_CENTS = "0.25";
	public static final String TEN_CENTS = "0.10";
	public static final String FIVE_CENTS = "0.05";
	public static final String ZERO = "0.00";
	
	// Products
	public static final String COLA = "cola";
	public static final String CHIPS = "chips";
	public static final String CANDY = "candy";
	
	// Product Prices
	public static final String COLA_PRICE = "1.00";
	public static final String CANDY_PRICE = "0.65";
	public static final String CHIPS_PRICE = "0.50";
	
	// General
	public static final String SOLD_OUT = "SOLD OUT";
	public static final String THANK_YOU = "THANK YOU";
	public static final String EXACT_CHANGE = "EXACT CHANGE ONLY";
	public static final String INSERT_COINS = "INSERT COINS";

	public static final Map<String, BigDecimal> coinValues;
	
	static {
		coinValues = new HashMap<String, BigDecimal>();
		coinValues.put(Constants.QUARTER, new BigDecimal(Constants.TWENTY_FIVE_CENTS));
		coinValues.put(Constants.DIME, new BigDecimal(Constants.TEN_CENTS));
		coinValues.put(Constants.NICKEL, new BigDecimal(Constants.FIVE_CENTS));
	}

}
