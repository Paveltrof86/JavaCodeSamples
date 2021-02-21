package com.paveltrofymov.codesamples.char_counter.services;

import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.RESULT_STRING_HELLO_WORLD;
import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.STRING_HELLO_WORLD;
import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.getResultMapFromStringHelloWorld;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;

class StringAnalyserImplTest {
    
   CharacterFinder finder = mock(CharacterFinder.class);
   PrettyViewFormatter formatter = mock(PrettyViewFormatter.class);
   StringAnalyserImpl analyser = new StringAnalyserImpl(finder, formatter);

    @Test
    void invokeSubservicesInRightOrderExpected_AndRightResultReturned() {
        Map<String, Integer> modelMap = getResultMapFromStringHelloWorld();
        String prettyResult = RESULT_STRING_HELLO_WORLD;
        
        when(finder.find(STRING_HELLO_WORLD)).thenReturn(modelMap);
        when(formatter.formatView(modelMap)).thenReturn(prettyResult);
        
        String result = analyser.analyse(STRING_HELLO_WORLD);
        assertEquals(prettyResult, result);
        
        verify(finder, times(1)).find(STRING_HELLO_WORLD);
        verify(formatter, times(1)).formatView(modelMap);
    }
}
