package main.java.product;
import java.math.BigDecimal;

import main.java.util.Constants;

public class Candy implements IProduct {

	private String type;
	private BigDecimal price;
	
	public Candy() {
		this.type = Constants.CANDY;
		this.price = new BigDecimal(Constants.CANDY_PRICE);
	}
	
	public String getType() {
		return this.type;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

}
