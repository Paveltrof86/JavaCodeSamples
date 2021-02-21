package com.paveltrofymov.codesamples.char_counter.services;

import java.util.HashMap;
import java.util.Map;

public class StringAnalyserCacheProxy implements StringAnalyser {
    private StringAnalyser analyserImpl = new StringAnalyserImpl();
    private Map<String, String> cache = new HashMap<>();
    
    public StringAnalyserCacheProxy() {}
    
    public StringAnalyserCacheProxy(StringAnalyser analyserImpl) {
        this.analyserImpl = analyserImpl;
    }

    @Override
    public String analyse(String inputString) {
        
        if (!cache.containsKey(inputString)) {
            String result = analyserImpl.analyse(inputString);
            cache.put(inputString, result);
        }
        
        return cache.get(inputString);
    }
}
