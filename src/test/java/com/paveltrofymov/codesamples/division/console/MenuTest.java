package com.paveltrofymov.codesamples.division.console;

import static com.paveltrofymov.codesamples.division.console.Menu.*;
import static com.paveltrofymov.codesamples.division.model.PrettyResultRepository.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.anyString;


import com.paveltrofymov.codesamples.division.services.IntegerDivision;
import org.junit.jupiter.api.Test;



class MenuTest {
    
    IntegerDivision divisionMock = mock(IntegerDivision.class);
    Menu menuSpy = spy(new Menu(divisionMock));

    @Test
    void run_UserInput_dividentANDdivisor_ReturnViewToPrint_integerDivisionModel() {
        doReturn(DIVIDEND_42569).doReturn(DIVISOR_326).doReturn(ESC).when(menuSpy).readLine();
        doNothing().when(menuSpy).printMessage(anyString());
        when(divisionMock.divide(42569, 326)).thenReturn(RESULT_STRING_42569_DIVIDED_BY_326);
        menuSpy.run();
        verify(menuSpy, atLeast(2)).printMessage(REQUEST_OF_DIVIDENT_AND_DIVIDER);
        verify(menuSpy, atLeast(1)).printMessage(ESC_MESSAGE);
        verify(menuSpy, atLeast(1)).printMessage(RESULT_STRING_42569_DIVIDED_BY_326);
        verify(divisionMock, times(1)).divide(42569, 326);
    }
}
