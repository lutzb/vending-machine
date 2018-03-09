package com.kata;

import java.util.ArrayList;
import java.util.Scanner;

import com.product.IProduct;

public class UserInteraction {
	
	private static VendingMachine vendingMachine;

	public static void main(String[] args) {
		
		vendingMachine = new VendingMachine(5, 5, 5);
		boolean userInteracting = true;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Greetings!");
		
		while(userInteracting) {
			printMenu();
			String userInput = in.nextLine();
			System.out.println("----------------------------------");
			
			switch (userInput) {
				case "1":
					insertCoins(in);
					break;
				case "2":
					buyProduct(in);
					break;
				case "3":
					checkProductReturn();
					break;
				case "4":
					returnChange();
					break;
				case "5":
					userInteracting = false;
					break;
				default:
					System.out.print("I'm not sure what you're trying to do... Please enter a single number 1 through 5.");
			}
		}
		
		System.out.println("Thank you for using this vending machine!");
		in.close();
	}

	private static void printMenu() {
		System.out.println("----------------------------------");
		System.out.println(vendingMachine.checkDisplay());
		System.out.println("----------------------------------");
		System.out.println("1: Insert Coins");
		System.out.println("2: Press Product Button");
		System.out.println("3: Check Product Return");
		System.out.println("4: Press Return Change Button");
		System.out.println("5: Exit");
		System.out.println("----------------------------------");
		System.out.print("What would you like to do: ");
	}

	private static void insertCoins(Scanner in) {
		boolean userInsertingCoins = true;
		while (userInsertingCoins) {
			System.out.print("Insert a coin (quarter, dime, or nickel) or type 'stop': ");
			String coin = in.nextLine();
			if (coin.equals("stop")) {
				userInsertingCoins = false;
			} else {
				vendingMachine.insertCoin(coin);
				System.out.println(vendingMachine.checkDisplay());				
			}
		}
	}
	
	private static void buyProduct(Scanner in) {
		System.out.print("Select a product to buy (cola, candy, or chips): ");
		String product = in.nextLine();
		System.out.println("----------------------------------");
		vendingMachine.pressProductButton(product);
		System.out.println(vendingMachine.checkDisplay());
	}
	
	private static void checkProductReturn() {
		IProduct product = vendingMachine.getProductReturn();
		vendingMachine.clearProductReturn();
		if (product == null) {
			System.out.println("Product return is empty.");
		} else {
			System.out.println("Product returned: " + product.getType());			
		}
	}
	
	private static void returnChange() {
		vendingMachine.pressReturnChangeButton();
		ArrayList<String> returnedCoins = vendingMachine.getCoinReturn();
		if (returnedCoins.isEmpty()) {
			System.out.println("Coin return is empty.");
		} else {
			for (String coin : returnedCoins) {
				System.out.println("Coin Returned: " + coin);
			}
			vendingMachine.clearCoinReturn();
		}
	}
}
