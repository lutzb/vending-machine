package main.java.kata;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.lang3.mutable.MutableInt;
import main.java.product.IProduct;

public class UserInteraction {

    private static VendingMachine vendingMachine;

    public static void main(String[] args) {

        vendingMachine = new VendingMachine(5, 5, 5);
        boolean userInteracting = true;
        Scanner in = new Scanner(System.in);

        printGreetingsArt();

        while (userInteracting) {
            printMenu();
            String userInput = in.nextLine();
            System.out.println("----------------------------------");

            switch (userInput) {
            case "1":
                checkInventory();
                break;
            case "2":
                insertCoins(in);
                break;
            case "3":
                selectProduct(in);
                break;
            case "4":
                returnChange();
                break;
            case "5":
                checkCoinReturn();
                break;
            case "6":
                userInteracting = false;
                break;
            default:
                System.out.println("I'm not sure what you're trying to do... Please enter a single number 1 through 5.");
            }
        }

        System.out.println("Thank you for using this vending machine!");
        in.close();
    }

    private static void printGreetingsArt() {
        InputStream art = UserInteraction.class.getResourceAsStream("art.txt");
        Scanner artIn = new Scanner(art);

        while (artIn.hasNext()) {
            System.out.println(artIn.nextLine());
        }

        artIn.close();
    }

    private static void printMenu() {
        System.out.println("----------------------------------");
        System.out.println("1: Check Inventory");
        System.out.println("2: Insert Coins");
        System.out.println("3: Purchase Product");
        System.out.println("4: Press Coin Return Button");
        System.out.println("5: Check Coin Return");
        System.out.println("6: Exit");
        System.out.println("----------------------------------");
        System.out.println("Display: " + vendingMachine.checkDisplay());
        System.out.println("----------------------------------");
        System.out.print("What would you like to do: ");
    }

    private static void checkInventory() {
        Map<String, MutableInt> inventory = vendingMachine.checkInventory();
        System.out.println("Current Inventory");
        System.out.println("----------------------------------");
        for (String productName : inventory.keySet()){
            System.out.println("Product: " + productName.toString() + " - Quantity: " + inventory.get(productName).toString());
        }
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
                System.out.println("Display: " + vendingMachine.checkDisplay());
            }
        }
    }

    private static void selectProduct(Scanner in) {
        System.out.print("Select a product (cola, candy, or chips): ");
        String productStr = in.nextLine();
        System.out.println("----------------------------------");
        IProduct product = vendingMachine.pressProductButton(productStr);
        System.out.println("Display: " + vendingMachine.checkDisplay());

        if (product != null) {
            System.out.println("Product: " + product.toString());
        }
    }

    private static void returnChange() {
        vendingMachine.pressReturnChangeButton();
    }

    private static void checkCoinReturn() {
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
