package com.paveltrofymov.codesamples.division.services;

import static com.paveltrofymov.codesamples.division.model.PrettyResultRepository.RESULT_STRING_373156_DIVIDED_BY_14;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.paveltrofymov.codesamples.division.model.DivisionModel;
import com.paveltrofymov.codesamples.division.model.DivisionModelRepository;

import org.junit.jupiter.api.Test;

class IntegerDivisionTest {
    
    DivisionModelCalculator calculator = mock(DivisionModelCalculator.class);
    PrettyResultFormatter formatter = mock(PrettyResultFormatter.class);
    IntegerDivision integerDivision = new IntegerDivision(calculator, formatter);

    @Test
    void  should_DivideToPass_When_DivisionModel_With_dividend_373156_divisor_14() {
        DivisionModel modelRepository = DivisionModelRepository.getResult_dividend_373156_divisor_14();
        String prettyResultModel = RESULT_STRING_373156_DIVIDED_BY_14;
        
        when(calculator.calculate(373156, 14)).thenReturn(modelRepository);
        when(formatter.construct(modelRepository)).thenReturn(prettyResultModel);
        
        String result = integerDivision.divide(373156, 14);
        assertEquals(prettyResultModel, result);
        
        verify(calculator, times(1)).calculate(373156, 14);
        verify(formatter, times(1)).construct(modelRepository);
    }
}
