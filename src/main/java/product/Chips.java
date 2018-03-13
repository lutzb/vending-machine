package main.java.product;
import java.math.BigDecimal;

import main.java.util.Constants;

public class Chips implements IProduct {

	private String type;
	private BigDecimal price;
	
	public Chips() {
		this.type = Constants.CHIPS;
		this.price = new BigDecimal(Constants.CHIPS_PRICE);
	}
	
	public String getType() {
		return this.type;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

}
