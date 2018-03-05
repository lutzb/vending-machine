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

}
