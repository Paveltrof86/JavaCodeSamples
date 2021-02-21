package com.paveltrofymov.codesamples.formula_1.services;

import java.util.ArrayList;
import java.util.List;

import com.paveltrofymov.codesamples.formula_1.model.Racer;

public class ReportProvider {
    private static final String START = "src/main/resources/start.log";
    private static final String END = "src/main/resources/end.log";
    private static final String ABBREVIATIONS = "src/main/resources/abbreviations.txt";
    private FilesFromResoursesReader reader = new FilesFromResoursesReader();
    private FilesParser parser = new FilesParser();
    private PrettyReportFormatter formatter = new PrettyReportFormatter();
    
    public String provide() {
        List<String> listFiles = new ArrayList<>();
        listFiles.addAll(reader.readFilesFromResources(START));
        listFiles.addAll(reader.readFilesFromResources(END));
        listFiles.addAll(reader.readFilesFromResources(ABBREVIATIONS));
        List<Racer> racers  = parser.parse(listFiles);
        String result = formatter.formatView(racers);
        
        return result;
    }
}
