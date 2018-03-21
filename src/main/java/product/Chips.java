package main.java.product;

import main.java.util.Constants;

public class Chips implements IProduct {

	private String type;
	private int price;

	public Chips() {
		this.type = Constants.CHIPS;
		this.price = Constants.CHIPS_PRICE;
	}

	public String getType() {
		return this.type;
	}

	public int getPrice() {
		return this.price;
	}

}
