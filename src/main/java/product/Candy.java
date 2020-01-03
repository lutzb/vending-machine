package main.java.product;

import main.java.util.Constants;

public class Candy implements IProduct {

    private String type;
    private int price;

    public Candy() {
        this.type = Constants.CANDY;
        this.price = Constants.CANDY_PRICE;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }
}
