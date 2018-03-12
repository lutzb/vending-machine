package main.java.product;

import main.java.exception.InvalidProductException;
import main.java.util.Constants;

public class ProductFactory {

	public static IProduct getProduct(String productType) throws InvalidProductException {
		if (productType == null) {
			throw new InvalidProductException("Null product type."); 
		} else if (productType.equals(Constants.COLA)) {
			return new Cola();
		} else if (productType.equals(Constants.CANDY)) {
			return new Candy();
		} else if (productType.equals(Constants.CHIPS)) {
			return new Chips();
		}
		
		throw new InvalidProductException("Unknown product type."); 
	}
}
	