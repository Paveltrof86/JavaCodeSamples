package com.paveltrofymov.codesamples.formula_1.model;

public class Racer {
    private String name;
    private String team;
    private Long racingPeriod;
    private String abbreviation;
    
    public Racer() {}

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public Long getRacingPeriod() {
        return racingPeriod;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setRacingPeriod(Long racingPeriod) {
        this.racingPeriod = racingPeriod;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    
}
