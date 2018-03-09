package com.kata;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import com.exception.InvalidProductException;
import com.product.IProduct;
import com.product.ProductFactory;

public class ProductFactoryTest {
    
	@Test
    public void whenProductFactoryIsPassedColaItReturnsColaProduct() throws InvalidProductException {
		IProduct product = ProductFactory.getProduct("cola");
    	assertEquals("cola", product.getType());
    }
    
	@Test
    public void whenProductFactoryIsPassedCandyItReturnsCandyProduct() throws InvalidProductException{
		IProduct product = ProductFactory.getProduct("candy");
    	assertEquals("candy", product.getType());
    }
	
	@Test
    public void whenProductFactoryIsPassedChipsItReturnsChipsProduct() throws InvalidProductException{
		IProduct product = ProductFactory.getProduct("chips");
    	assertEquals("chips", product.getType());
    }
	
	@Test(expected = InvalidProductException.class)
	public void whenProductFactoryIsPassedANullItThrowsAnException() throws InvalidProductException{
		ProductFactory.getProduct(null);
	}
	
	@Test(expected = InvalidProductException.class)
	public void whenProductFactoryIsPassedAnInvalidProductItThrowsAnException() throws InvalidProductException{
		ProductFactory.getProduct("z");
	}
}


