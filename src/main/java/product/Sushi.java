package main.java.product;

import main.java.util.Constants;

public class Sushi implements IProduct {

    private String type;
    private int price;

    public Sushi() {
        this.type = Constants.SUSHI;
        this.price = Constants.SUSHI_PRICE;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }
}
