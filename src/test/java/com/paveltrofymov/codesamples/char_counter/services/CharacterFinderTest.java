package com.paveltrofymov.codesamples.char_counter.services;

import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class CharacterFinderTest {
    
    CharacterFinder finder = new CharacterFinder();

    @Test
    void whenInvokeWithString1_thenMapModel1Returned() {
        Map<String, Integer> expected = getResultMapFromStringHelloWorld();
        Map<String, Integer> actual = finder.find(STRING_HELLO_WORLD);
        assertEquals(expected, actual);
    }
    
    @Test
    void whenInvokeWithString2_thenMapModel2Returned() {
        Map<String, Integer> expected = getResultMapFromStringProton1();
        Map<String, Integer> actual = finder.find(STRING_PROTON_1);
        assertEquals(expected, actual);
    }
    
    @Test
    void whenInvokeWithString3_thenMapModel3Returned() {
        Map<String, Integer> expected = getResultMapFromStringBingoBongo();
        Map<String, Integer> actual = finder.find(STRING_BINGO_BONGO);
        assertEquals(expected, actual);
    }
}
