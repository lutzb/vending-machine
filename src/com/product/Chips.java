package com.product;
import java.math.BigDecimal;

public class Chips implements IProduct {

	private String type;
	
	private BigDecimal price;
	
	public Chips() {
		this.type = "chips";
		this.price = new BigDecimal("0.50");
	}
	
	public String getType() {
		return this.type;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

}
