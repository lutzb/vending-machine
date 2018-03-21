package main.java.util;

import java.text.DecimalFormat;

public class VendingMachineUtil {

	public static String centsToDollars(int amount) {
		return (new DecimalFormat("0.00")).format(amount / 100.0);
	}

	public static int determineNumberOfCoinsDue(int coinValue, int customerBalance) {
		return customerBalance / coinValue;
	}
}
