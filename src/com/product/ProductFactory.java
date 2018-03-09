package com.product;

public class ProductFactory {

	public static IProduct getProduct(String productType) {
		if (productType == null) {
			return null; 
		} else if (productType.equals("cola")) {
			return new Cola();
		} else if (productType.equals("candy")) {
			return new Candy();
		} else if (productType.equals("chips")) {
			return new Chips();
		}
		
		return null;
	}
}
	