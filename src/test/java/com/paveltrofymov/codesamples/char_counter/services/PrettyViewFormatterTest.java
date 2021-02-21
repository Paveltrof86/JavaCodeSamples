package com.paveltrofymov.codesamples.char_counter.services;

import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class PrettyViewFormatterTest {
    
    PrettyViewFormatter formatter = new PrettyViewFormatter();

    @Test
    void whenInvokeWithMapModel1_thenExpectedString1Returned() {
        String expected = RESULT_STRING_HELLO_WORLD;
        Map<String, Integer> modelMap = getResultMapFromStringHelloWorld();
        String actual = formatter.formatView(modelMap);
        assertEquals(expected, actual);
    }
    
    @Test
    void whenInvokeWithMapModel2_thenExpectedString2Returned() {
        String expected = RESULT_STRING_PROTON_1;
        Map<String, Integer> modelMap = getResultMapFromStringProton1();
        String actual = formatter.formatView(modelMap);
        assertEquals(expected, actual);
    }
    
    @Test
    void whenInvokeWithMapModel3_thenExpectedString3Returned() {
        String expected = RESULT_STRING_BINGO_BONGO;
        Map<String, Integer> modelMap = getResultMapFromStringBingoBongo();
        String actual = formatter.formatView(modelMap);
        assertEquals(expected, actual);
    }
}
