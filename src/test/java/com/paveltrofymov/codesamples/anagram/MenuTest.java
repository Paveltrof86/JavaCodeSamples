package com.paveltrofymov.codesamples.anagram;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class MenuTest {
    
    Anagram anagramMock = mock(Anagram.class);
    Menu menuSpy = spy(new Menu(anagramMock));
    
    @Test
    void run_UserInputString_ReturnReversedString() {
        doReturn("rewers").doReturn(Menu.ESC).when(menuSpy).readLine();
        when(anagramMock.reverseString("rewers")).thenReturn("srewer");
        menuSpy.run();
        verify(menuSpy, atLeast(2)).printMessage(Menu.REQUEST_TO_DO);
        verify(menuSpy, atLeast(1)).printMessage("srewer");
        verify(anagramMock).reverseString("rewers");
    }
}

