package com.paveltrofymov.codesamples.formula_1.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.paveltrofymov.codesamples.formula_1.model.Racer;

import static java.lang.String.join;

public class FilesParser {
    private static final String VERTICAL_LINE = "|";
    private static final String VERTICAL_LINE_REGEX_SPLIT = "\\|";
    private static final String UNDERLINE = "_";
    private static final String RACING_START_END_TIME_FORMAT = "yyyy-MM-dd_HH:mm:ss.SSS";
    
    public List<Racer> parse(List<String> listFiles) {
        List<Racer> racers = new ArrayList<>();
        
        Map<String, String> map = listFiles
                .stream()
                .collect(
                        Collectors.toMap(
                                k -> k.substring(0, 3), v -> v.substring(3),
                                (a, b) -> join(VERTICAL_LINE, a, b),
                                HashMap::new
                                )
                        );
        
        parseBetweenStartEndRacerPeriod(racers, map);
        parseNameAndTeam(racers, map);
        
        return racers;
    }
    
    private void parseBetweenStartEndRacerPeriod(List<Racer> racers, Map<String, String> map) {
        for(Map.Entry<String, String> entry : map.entrySet()) {
            Racer racer = new Racer();
            
            racer.setAbbreviation(entry.getKey());
            String line = entry.getValue();
            
            String time = line.substring(0, line.lastIndexOf(VERTICAL_LINE));
            String[] timeSplit = time.split(VERTICAL_LINE_REGEX_SPLIT);
            LocalDateTime localDateTimeStart = LocalDateTime.parse(timeSplit[0], DateTimeFormatter.ofPattern(RACING_START_END_TIME_FORMAT));
            LocalDateTime localDateTimeEnd = LocalDateTime.parse(timeSplit[1], DateTimeFormatter.ofPattern(RACING_START_END_TIME_FORMAT));
            long millisBetween = ChronoUnit.MILLIS.between(localDateTimeStart, localDateTimeEnd);
            racer.setRacingPeriod(millisBetween);
            
            racers.add(racer);
        }
    }

    private void parseNameAndTeam(List<Racer> racers, Map<String, String> map) {
        for (int i = 0; i < racers.size(); i++) {
            if(map.containsKey(racers.get(i).getAbbreviation())) {
                String line = map.get(racers.get(i).getAbbreviation());
                String nameAndTeam = line.substring(line.lastIndexOf(VERTICAL_LINE) + 2, line.length());
                String[] nameAndTeamSplit = nameAndTeam.split(UNDERLINE);
                
                racers.get(i).setName(nameAndTeamSplit[0]);
                racers.get(i).setTeam(nameAndTeamSplit[1]);
            }
        }
    }
}
