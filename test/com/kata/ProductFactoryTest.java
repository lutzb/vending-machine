package com.kata;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ProductFactoryTest {
    
	@Test
    public void whenProductFactoryIsPassedColaItReturnsColaProduct() {
		IProduct product = ProductFactory.getProduct("cola");
    	assertEquals("cola", product.getType());
    }
    
	@Test
    public void whenProductFactoryIsPassedCandyItReturnsCandyProduct() {
		IProduct product = ProductFactory.getProduct("candy");
    	assertEquals("candy", product.getType());
    }
	
	@Test
    public void whenProductFactoryIsPassedChipsItReturnsChipsProduct() {
		IProduct product = ProductFactory.getProduct("chips");
    	assertEquals("chips", product.getType());
    }
}


