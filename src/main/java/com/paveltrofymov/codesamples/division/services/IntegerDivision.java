package com.paveltrofymov.codesamples.division.services;

import com.paveltrofymov.codesamples.division.model.DivisionModel;

public class IntegerDivision {
    
    private DivisionModelCalculator calculator = new DivisionModelCalculator();
    private PrettyResultFormatter formatter = new PrettyResultFormatter();
    
    public IntegerDivision() {}
    
    public IntegerDivision(DivisionModelCalculator calculator, PrettyResultFormatter formatter) {
        this.calculator = calculator;
        this.formatter = formatter;
    }

    public String divide(int dividend, int divisor) {
        DivisionModel model = calculator.calculate(dividend, divisor);
        String result = formatter.construct(model);
        return result;
    }
}
