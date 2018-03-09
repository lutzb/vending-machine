package com.kata;
import static junit.framework.TestCase.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.util.VendingMachineUtil;

public class VendingMachineUtilTest {
	
    @Test
    public void whenPadPriceWithZeroIsGivenADoubleDigitValueItReturnsThatValue() {
    	assertEquals("0.15", VendingMachineUtil.padPriceWithZero(new BigDecimal("0.15")));
    }
    
    @Test
    public void whenPadPriceWithZeroIsGivenASingleDigitValueItReturnsThatValuePaddedWithAZero() {
    	assertEquals("0.10", VendingMachineUtil.padPriceWithZero(new BigDecimal("0.1")));
    }
    
    @Test
    public void whenDetermineNumberOfCoinsDueIsGivenA50CentsBalanceAnd25CentsValueItReturns2() {
    	BigDecimal customerBalance = new BigDecimal("0.50");
    	assertEquals(2, VendingMachineUtil.determineNumberOfCoinsDue(new BigDecimal("0.25"), customerBalance));
    }
    
    @Test
    public void whenDetermineNumberOfCoinsDueIsGivenA50CentsBalanceAnd10CentsValueItReturns5() {
    	BigDecimal customerBalance = new BigDecimal("0.50");
    	assertEquals(5, VendingMachineUtil.determineNumberOfCoinsDue(new BigDecimal("0.10"), customerBalance));
    }
    
    @Test
    public void whenDetermineNumberOfCoinsDueIsGivenA50CentsBalanceAnd5CentsValueItReturns10() {
    	BigDecimal customerBalance = new BigDecimal("0.50");
    	assertEquals(10, VendingMachineUtil.determineNumberOfCoinsDue(new BigDecimal("0.05"), customerBalance));
    }
    
    @Test
    public void whenDetermineNumberOfCoinsDueIsGivenA65CentsBalanceAnd25CentsItReturns2() {
    	BigDecimal customerBalance = new BigDecimal("0.65");
    	assertEquals(2, VendingMachineUtil.determineNumberOfCoinsDue(new BigDecimal("0.25"), customerBalance));
    }
    
    @Test
    public void whenDetermineNumberOfCoinsDueIsGivenA65CentsBalanceAnd5CentsItReturns13() {
    	BigDecimal customerBalance = new BigDecimal("0.65");
    	assertEquals(13, VendingMachineUtil.determineNumberOfCoinsDue(new BigDecimal("0.05"), customerBalance));
    }

}
