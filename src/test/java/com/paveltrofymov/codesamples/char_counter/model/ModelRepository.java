package com.paveltrofymov.codesamples.char_counter.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModelRepository {
    
    public static final String STRING_HELLO_WORLD = "Hello World!";
    
    public static final String RESULT_STRING_HELLO_WORLD = 
            "\"H\" - 1\r\n" + 
            "\"e\" - 1\r\n" + 
            "\"l\" - 3\r\n" + 
            "\"o\" - 2\r\n" +
            "\" \" - 1\r\n" +
            "\"W\" - 1\r\n" + 
            "\"r\" - 1\r\n" + 
            "\"d\" - 1\r\n" + 
            "\"!\" - 1\r\n";
    
    public static Map<String, Integer> getResultMapFromStringHelloWorld() {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("H", 1);
        map.put("e", 1);
        map.put("l", 3);
        map.put("o", 2);
        map.put(" ", 1);
        map.put("W", 1);
        map.put("r", 1);
        map.put("d", 1);
        map.put("!", 1);
        return map;
    }
    
    public static final String STRING_PROTON_1 = "Proton_1";
    
    public static final String RESULT_STRING_PROTON_1 = 
            "\"P\" - 1\r\n" + 
            "\"r\" - 1\r\n" + 
            "\"o\" - 2\r\n" + 
            "\"t\" - 1\r\n" +
            "\"n\" - 1\r\n" + 
            "\"_\" - 1\r\n" + 
            "\"1\" - 1\r\n";
    
    public static Map<String, Integer> getResultMapFromStringProton1() {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("P", 1);
        map.put("r", 1);
        map.put("o", 2);
        map.put("t", 1);
        map.put("n", 1);
        map.put("_", 1);
        map.put("1", 1);
        return map;
    }
    
    public static final String STRING_BINGO_BONGO = "BinGO-bongo";
    
    public static final String RESULT_STRING_BINGO_BONGO = 
            "\"B\" - 1\r\n" + 
            "\"i\" - 1\r\n" + 
            "\"n\" - 2\r\n" + 
            "\"G\" - 1\r\n" +
            "\"O\" - 1\r\n" + 
            "\"-\" - 1\r\n" + 
            "\"b\" - 1\r\n" + 
            "\"o\" - 2\r\n" + 
            "\"g\" - 1\r\n";
    
    public static Map<String, Integer> getResultMapFromStringBingoBongo() {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("B", 1);
        map.put("i", 1);
        map.put("n", 2);
        map.put("G", 1);
        map.put("O", 1);
        map.put("-", 1);
        map.put("b", 1);
        map.put("o", 2);
        map.put("g", 1);
        return map;
    }
}
