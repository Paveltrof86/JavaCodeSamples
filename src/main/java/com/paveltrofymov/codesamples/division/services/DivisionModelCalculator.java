package com.paveltrofymov.codesamples.division.services;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.paveltrofymov.codesamples.division.model.DivisionModel;
import com.paveltrofymov.codesamples.division.model.DivisionStep;

public class DivisionModelCalculator {
    
    public static final String SMALL_DIVIDENT_MESSAGE = "Dividend is low than divider, result = 0. Try again!";
    public static final String DIVIZION_BY_ZERO_MESSAGE = "Divisor cannot be 0, division by zero";

    public DivisionModel calculate(int dividend, int divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException(DIVIZION_BY_ZERO_MESSAGE);
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor) {
            throw new IllegalArgumentException(SMALL_DIVIDENT_MESSAGE);
        }
        
        DivisionModel model = new DivisionModel();
        
        model.setDividend(Integer.toString(dividend));
        model.setDivisor(Integer.toString(divisor));
        model.setQuotient(Integer.toString(dividend / divisor));

        String[] digits = String.valueOf(dividend).split(EMPTY);
        String reminder = EMPTY;
        
        for (int i = 0; i < digits.length; i++) {
            reminder += digits[i];
            int intReminder = Integer.valueOf(reminder);
            
            if (intReminder >= divisor) {
                int quotient = intReminder / divisor;
                int secondOperand = quotient * divisor;
                int mod = intReminder % divisor;
                model.getDivisionSteps().add(new DivisionStep(intReminder, secondOperand, mod));
                reminder = Integer.toString(mod);
                
                if(mod == 0) {
                    reminder = EMPTY;
                }
            } else if ((intReminder < divisor) && (i == digits.length - 1)) {
                model.getDivisionSteps().add(new DivisionStep(intReminder, 0, 0));
            }
        }
        return model;
    }
}
