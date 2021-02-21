package com.paveltrofymov.codesamples.division.services;

import static com.paveltrofymov.codesamples.division.services.DivisionModelCalculator.DIVIZION_BY_ZERO_MESSAGE;
import static com.paveltrofymov.codesamples.division.services.DivisionModelCalculator.SMALL_DIVIDENT_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paveltrofymov.codesamples.division.model.DivisionModel;
import com.paveltrofymov.codesamples.division.model.DivisionModelRepository;

import org.junit.jupiter.api.Test;

class DivisionModelCalculatorTest {

    DivisionModelCalculator calculator = new DivisionModelCalculator();
    
    @Test
    public void when_DivisionModel_With_dividend_373156_divisor_14_Expect_isEqualsTrue() {
        DivisionModel expected = DivisionModelRepository.getResult_dividend_373156_divisor_14();
        DivisionModel actual = calculator.calculate(373156, 14);
        assertEquals(expected, actual);
    }
    
    @Test
    public void when_DivisionModel_With_dividend_42569_divisor_326_Expect_isEqualsTrue() {
        DivisionModel expected = DivisionModelRepository.getResult_dividend_42569_divisor_326();
        DivisionModel actual = calculator.calculate(42569, 326);
        assertEquals(expected, actual);
    }
    
    @Test
    public void when_DivisionModel_With_dividend_25_divisor_5_Expect_isEqualsTrue() {
        DivisionModel expected = DivisionModelRepository.getResult_dividend_25_divisor_5();
        DivisionModel actual = calculator.calculate(25, 5);
        assertEquals(expected, actual);
    }
    
    @Test
    public void when_DivisionModel_With_divisor_0_then_ReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, 
                    () -> calculator.calculate(50, 0), DIVIZION_BY_ZERO_MESSAGE);
    }
    
    @Test
    public void when_DivisionModel_With_dividend_LessThan_divisor_then_ReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, 
                    () -> calculator.calculate(25, 366), SMALL_DIVIDENT_MESSAGE);
    }
}
