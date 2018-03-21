package main.java;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import main.java.exception.InvalidProductException;
import main.java.product.IProduct;
import main.java.product.ProductFactory;

public class ProductFactoryTest {

	@Test
	public void whenProductFactoryIsPassedColaItReturnsColaProduct() throws InvalidProductException {
		IProduct product = ProductFactory.getProduct("cola");
		assertEquals("cola", product.getType());
	}

	@Test
	public void whenProductFactoryIsPassedCandyItReturnsCandyProduct() throws InvalidProductException {
		IProduct product = ProductFactory.getProduct("candy");
		assertEquals("candy", product.getType());
	}

	@Test
	public void whenProductFactoryIsPassedChipsItReturnsChipsProduct() throws InvalidProductException {
		IProduct product = ProductFactory.getProduct("chips");
		assertEquals("chips", product.getType());
	}

	@Test(expected = InvalidProductException.class)
	public void whenProductFactoryIsPassedANullItThrowsAnException() throws InvalidProductException {
		ProductFactory.getProduct(null);
	}

	@Test(expected = InvalidProductException.class)
	public void whenProductFactoryIsPassedAnInvalidProductItThrowsAnException() throws InvalidProductException {
		ProductFactory.getProduct("z");
	}
}
