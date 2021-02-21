package com.paveltrofymov.codesamples.char_counter.services;

import java.util.Map;

public class StringAnalyserImpl implements StringAnalyser{
    private CharacterFinder finder = new CharacterFinder();
    private PrettyViewFormatter formatter = new PrettyViewFormatter();

    public StringAnalyserImpl() {}

    public StringAnalyserImpl(CharacterFinder finder, PrettyViewFormatter formatter) {
        this.finder = finder;
        this.formatter = formatter;
    }

    @Override
    public String analyse(String inputString) {
        Map<String, Integer> resultMap = finder.find(inputString);
        return formatter.formatView(resultMap);
    }
}
