package com.paveltrofymov.codesamples.formula_1.services;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.paveltrofymov.codesamples.formula_1.model.Racer;

import static org.apache.commons.lang3.StringUtils.repeat;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.LF;

public class PrettyReportFormatter {
    private static final String RACING_TIME_FORMAT = "mm:ss.SSS";
    private static final String DIVIDING_LINE = "-";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(RACING_TIME_FORMAT);
    
    public String formatView(List<Racer> racers) {
        
        racers.sort(Comparator.comparingLong(Racer::getRacingPeriod));
        
        int maxNameLength = racers
                .stream()
                .max(Comparator.comparingInt(a -> a.getName().length()))
                .get().getName().length();
       
        int maxTeamLength = racers
                .stream()
                .max(Comparator.comparingInt(a -> a.getTeam().length()))
                .get().getTeam().length();

        List<String> finalReportList = IntStream.range(0, racers.size())
                .mapToObj(index -> formatLine(racers, index, maxNameLength, maxTeamLength))
                .collect(Collectors.toList());
        
        return join(finalReportList, "");
    }
    
    private String formatLine(List<Racer> racers, int index, int maxNameLength, int maxTeamLength) {
        StringBuilder result = new StringBuilder();
        String line = String.format("%d. %-" + maxNameLength + "s | %-" + maxTeamLength + "s | %s%n",
                index+1,
                racers.get(index).getName(),
                racers.get(index).getTeam(),
                dateFormat.format(new Date(racers.get(index).getRacingPeriod())));
        
        result.append(line);
        
        if(index == 14) {
            String dividingLine = repeat(DIVIDING_LINE, line.length());
            result.append(dividingLine).append(LF);
        }
        
        return result.toString();
    }
}
