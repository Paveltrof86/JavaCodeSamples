package com.paveltrofymov.codesamples.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class AnagramTest {

    Anagram anagramSpy = spy(new Anagram());
    
    @Test
    public void when_InvokeStringWithOneWord_then_ReturnWordReversed() {
        String expected = "gfdt";
        String actual = "tdfg";
        doReturn(expected).when(anagramSpy).reverseWord(actual);
        assertEquals(expected, anagramSpy.reverseString(actual), "Should return reversed string with one words");
        verify(anagramSpy).reverseWord(actual);
    }

    @Test
    public void when_InvokeStringWithTwoWords_then_ReturnStringWithTwoWordsReversed() {
        String expected = "gfd1t 123&&";
        String actual = "tdf1g 123&&";
        doReturn("gfd1t").when(anagramSpy).reverseWord("tdf1g");
        doReturn("123&&").when(anagramSpy).reverseWord("123&&");
        assertEquals(expected, anagramSpy.reverseString(actual), "Should return reversed string with two words");
        verify(anagramSpy).reverseWord("tdf1g");
        verify(anagramSpy).reverseWord("123&&");
    }
    
    @Test
    public void when_InvokeStringNull_then_ReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, 
                    () -> anagramSpy.reverseString(null), Anagram.EXCEPTION_MESSAGE);
    }
    
    @Test
    public void when_InvokeWithEmptyString_then_ReturnEmptyString() {
        assertEquals("", anagramSpy.reverseString(""), "Should return an empty string");
        verify(anagramSpy, never()).reverseWord(anyString());
    }
    
    @Test
    public void when_InvokeWithStringOnlyWhitespace_then_ReturnEmptyString() {
        assertEquals("", anagramSpy.reverseString(" "), "Should return an empty string");
        verify(anagramSpy, never()).reverseWord(anyString());
    }
    
    @Test
    public void when_InvokeWithStringOnlyWhitespaces_then_ReturnEmptyString() {
        assertEquals("", anagramSpy.reverseString("    "), "Should return an empty string");
        verify(anagramSpy, never()).reverseWord(anyString());
    }

    @Test
    void when_InvokeWordWithOnlyLetters_then_ReturnWordWithOnlyLettersReversed() {
        assertEquals("ret", anagramSpy.reverseWord("ter"), "Should return reversed word contains only letters");
    }
    
    @Test
    void when_InvokeWordWithOnlyDigits_then_ReturnWordWithOnlyDigitsNotReversed() {
        assertEquals("1234", anagramSpy.reverseWord("1234"), "Should return  not reversed word contains only digits");
    }
    
    @Test
    void when_InvokeWordWithOnlySymbols_then_ReturnWordWithOnlySymbolsNotReversed() {
        assertEquals("!!$&&", anagramSpy.reverseWord("!!$&&"), "Should return not reversed word contains only symbols");
    }
    
    @Test
    void when_InvokeWordWithLettersAndSymbols_then_ReturnWordWithOnlyLettersReversed() {
        assertEquals("cba$$", anagramSpy.reverseWord("abc$$"), "Should return reversed word contains letters and symbols");
    }
    
    @Test
    void when_InvokeWordWithLettersAndDigits_then_ReturnWordOnlyLettersReversed() {
        assertEquals("wer1", anagramSpy.reverseWord("rew1"), "Should return reversed word contains letters and digits");
    }
    
    @Test
    void when_InvokeWordWithSymbolsAndDigits_then_ReturnWordWithSymbolsAndDigitsNotReversed() {
        assertEquals("12**", anagramSpy.reverseWord("12**"), "Should return not reversed word contains symbols and digits");
    }
}
