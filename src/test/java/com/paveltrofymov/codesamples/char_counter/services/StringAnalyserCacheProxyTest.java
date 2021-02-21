package com.paveltrofymov.codesamples.char_counter.services;


import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.RESULT_STRING_HELLO_WORLD;
import static com.paveltrofymov.codesamples.char_counter.model.ModelRepository.STRING_HELLO_WORLD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class StringAnalyserCacheProxyTest {
    
    StringAnalyser analyserImpl = mock(StringAnalyserImpl.class);
    StringAnalyserCacheProxy cacheProxy = new StringAnalyserCacheProxy(analyserImpl);

    @Test
    void whenInvokeWithSameInput_thenInvokeServiceOnlyOnce() {
        when(analyserImpl.analyse(STRING_HELLO_WORLD)).thenReturn(RESULT_STRING_HELLO_WORLD);
        
        String actualHelloWorld1 = cacheProxy.analyse(STRING_HELLO_WORLD);
        String actualHelloWorld2 = cacheProxy.analyse(STRING_HELLO_WORLD);
        String actualHelloWorld3 = cacheProxy.analyse(STRING_HELLO_WORLD);
        
        assertEquals(RESULT_STRING_HELLO_WORLD, actualHelloWorld1);
        assertEquals(RESULT_STRING_HELLO_WORLD, actualHelloWorld2);
        assertEquals(RESULT_STRING_HELLO_WORLD, actualHelloWorld3);
        
        verify(analyserImpl, times(1)).analyse(STRING_HELLO_WORLD);
    }
}
