package com.paveltrofymov.codesamples.division.services;

import static com.paveltrofymov.codesamples.division.model.PrettyResultRepository.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paveltrofymov.codesamples.division.model.DivisionModel;
import com.paveltrofymov.codesamples.division.model.DivisionModelRepository;

import org.junit.jupiter.api.Test;

class PrettyResultFormatterTest {
    
    PrettyResultFormatter formatter = new PrettyResultFormatter();
    
    @Test
    public void when_InvokeDivisionModel_With_dividend_373156_divisor_14_then_PassExpectedString() {
        String expected = RESULT_STRING_373156_DIVIDED_BY_14;
        DivisionModel model = DivisionModelRepository.getResult_dividend_373156_divisor_14();
        String actual = formatter.construct(model);
        assertEquals(expected, actual);
    }
 
    @Test
    public void when_InvokeDivisionModel_With_dividend_42569_divisor_326_then_PassExpectedString() {
        String expected = RESULT_STRING_42569_DIVIDED_BY_326;
        DivisionModel model = DivisionModelRepository.getResult_dividend_42569_divisor_326();
        String actual = formatter.construct(model);
        assertEquals(expected, actual);
    }
    
    @Test
    public void when_InvokeDivisionModel_With_dividend_25_divisor_5_then_PassExpectedString() {
        String expected = RESULT_STRING_25_DIVIDED_BY_5;
        DivisionModel model = DivisionModelRepository.getResult_dividend_25_divisor_5();
        String actual = formatter.construct(model);
        assertEquals(expected, actual);
    }
}
