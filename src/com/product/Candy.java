package com.product;
import java.math.BigDecimal;

public class Candy implements IProduct {

	private String type;
	
	private BigDecimal price;
	
	public Candy() {
		this.type = "candy";
		this.price = new BigDecimal("0.65");
	}
	
	public String getType() {
		return this.type;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

}
