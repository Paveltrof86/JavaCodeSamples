package com.paveltrofymov.codesamples.char_counter.services;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.countMatches;

public class CharacterFinder {
    
    public Map<String, Integer> find(String inputString) {
        List<String> list = asList(inputString.split(EMPTY));
        
        Map<String, Integer> result = list
                .stream()
                .distinct()
                .collect(LinkedHashMap::new,
                        (map, s) -> map.put(s, countMatches(inputString, s)),
                        Map::putAll);
        return result;
    }
}
