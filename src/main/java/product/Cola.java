package main.java.product;

import main.java.util.Constants;

public class Cola implements IProduct {
	
	private String type;
	private int price;
	
	public Cola() {
		this.type = Constants.COLA;
		this.price = Constants.COLA_PRICE;
	}

	public String getType() {
		return this.type;
	}
	
	public int getPrice() {
		return this.price;
	}
	
}
