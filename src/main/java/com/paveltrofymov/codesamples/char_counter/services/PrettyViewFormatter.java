package com.paveltrofymov.codesamples.char_counter.services;

import static java.lang.String.format;

import java.util.Map;

public class PrettyViewFormatter {
    private static final String LINE_FORMAT = "\"%s\" - %d%n";
    
    public String formatView(Map<String, Integer> mapModel) {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> elem : mapModel.entrySet()) {
            String formatLine = format(LINE_FORMAT, elem.getKey(), elem.getValue());
            result.append(formatLine);
        }
        return result.toString();
    }
}
