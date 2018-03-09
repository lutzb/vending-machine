package com.util;

import java.math.BigDecimal;

public class VendingMachineUtil {

	public static String padPriceWithZero(BigDecimal amount) {
    	String amountStr = String.valueOf(amount);
    	// Check number of decimal places
		int indexOfDecimal = amountStr.indexOf(".");
		String decimalPlaces = amountStr.substring(indexOfDecimal + 1);
		
		// Add a '0' to the end of the display if balance only has one decimal place
		if (decimalPlaces.length() < 2) {
			amountStr += "0";
		}
		
		return amountStr;
    }

	public static int determineNumberOfCoinsDue(BigDecimal coinValue, BigDecimal customerBalance) {
		return customerBalance.divide(coinValue).toBigInteger().intValue();
	}
}
