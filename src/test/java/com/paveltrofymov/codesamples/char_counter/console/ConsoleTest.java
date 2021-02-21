package com.paveltrofymov.codesamples.char_counter.console;

import static com.paveltrofymov.codesamples.char_counter.console.Console.*;
import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.RESULT_STRING_HELLO_WORLD;
import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.STRING_HELLO_WORLD;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.paveltrofymov.codesamples.char_counter.services.StringAnalyser;
import com.paveltrofymov.codesamples.char_counter.services.StringAnalyserCacheProxy;

import org.junit.jupiter.api.Test;

class ConsoleTest {

    StringAnalyser analyser = mock(StringAnalyserCacheProxy.class);
    Console consoleSpy = spy(new Console(analyser));

    @Test
    void runMenuWithOneUserInpunAndExit() {
        doReturn(STRING_HELLO_WORLD).doReturn(ESC).when(consoleSpy).readLine();
        doNothing().when(consoleSpy).printMessage(anyString());
        when(analyser.analyse(STRING_HELLO_WORLD)).thenReturn(RESULT_STRING_HELLO_WORLD);
        consoleSpy.run();
        verify(consoleSpy, atLeast(2)).printMessage(REQUEST_TO_DO);
        verify(consoleSpy, atLeast(1)).printMessage(ESC_MESSAGE);
        verify(consoleSpy, atLeast(1)).printMessage(RESULT_STRING_HELLO_WORLD);
        verify(analyser, times(1)).analyse(STRING_HELLO_WORLD);
    }
}
