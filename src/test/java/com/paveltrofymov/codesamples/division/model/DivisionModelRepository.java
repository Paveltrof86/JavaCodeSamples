package com.paveltrofymov.codesamples.division.model;

public class DivisionModelRepository{
    
    public static DivisionModel getResult_dividend_373156_divisor_14() {
        DivisionModel modelRepository = new DivisionModel("373156", "14", "26654");
        modelRepository.getDivisionSteps().add(new DivisionStep(37, 28, 9));
        modelRepository.getDivisionSteps().add(new DivisionStep(93, 84, 9));
        modelRepository.getDivisionSteps().add(new DivisionStep(91, 84, 7));
        modelRepository.getDivisionSteps().add(new DivisionStep(75, 70, 5));
        modelRepository.getDivisionSteps().add(new DivisionStep(56, 56, 0));
        return modelRepository;
    }
    
    public static DivisionModel getResult_dividend_42569_divisor_326() {
        DivisionModel modelRepository = new DivisionModel("42569", "326", "130");
        modelRepository.getDivisionSteps().add(new DivisionStep(425, 326, 99));
        modelRepository.getDivisionSteps().add(new DivisionStep(996, 978, 18));
        modelRepository.getDivisionSteps().add(new DivisionStep(189, 0, 0));
        return modelRepository;
    }
    
    public static DivisionModel getResult_dividend_25_divisor_5() {
        DivisionModel modelRepository = new DivisionModel("25", "5", "5");
        modelRepository.getDivisionSteps().add(new DivisionStep(25, 25, 0)); 
        return modelRepository;
    }
}
