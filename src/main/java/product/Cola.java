package main.java.product;
import java.math.BigDecimal;

import main.java.util.Constants;

public class Cola implements IProduct {
	
	private String type;
	private BigDecimal price;
	
	public Cola() {
		this.type = Constants.COLA;
		this.price = new BigDecimal(Constants.COLA_PRICE);
	}

	public String getType() {
		return this.type;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
}
