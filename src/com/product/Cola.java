package com.product;
import java.math.BigDecimal;

public class Cola implements IProduct {
	
	private String type;
	
	private BigDecimal price;
	
	public Cola() {
		this.type = "cola";
		this.price = new BigDecimal("1.00");
	}

	public String getType() {
		return this.type;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
}
