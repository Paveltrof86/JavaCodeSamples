package com.paveltrofymov.codesamples.division.services;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.apache.commons.lang3.StringUtils.rightPad;
import static org.apache.commons.lang3.StringUtils.repeat;
import static java.lang.Math.max;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.lang.Integer.parseInt;
import java.util.List;

import com.paveltrofymov.codesamples.division.model.DivisionStep;
import com.paveltrofymov.codesamples.division.model.DivisionModel;

public class PrettyResultFormatter {
    private static final String VERTICAL_LINE = "|";
    private static final String MINUS = "_";
    private static final String UNDERLINE = "-";

    public String construct(DivisionModel model) {
        StringBuilder result = new StringBuilder();
        result.append(formHead(model));
        result.append(formBody(model.getDivisionSteps(), model.getDividend()));
        return result.toString();
    }

    private String formHead(DivisionModel model) {
        StringBuilder resultHead = new StringBuilder();
        String modelDividend = model.getDividend();
        String modelDivisor = model.getDivisor();
        String modelQuotient = model.getQuotient();
        int lengthLeftPart = valueOf(modelDividend).length();
        int lengthDivisorNumber = valueOf(modelDivisor).length();
        int lengthResultNumber = valueOf(modelQuotient).length();
        int lengthRightPart = max(lengthDivisorNumber, lengthResultNumber);
        
        String firstStringHeader = format("%s%-" + lengthLeftPart + "d%s%d%n", MINUS, 
               parseInt(modelDividend), VERTICAL_LINE, parseInt(modelDivisor));
        resultHead.append(firstStringHeader);

        String secondStringHeader = format(" %-" + lengthLeftPart + "d%s%s%n",
                model.getDivisionSteps().get(0).getSecondOperand(), VERTICAL_LINE, repeat(UNDERLINE, lengthRightPart));
        resultHead.append(secondStringHeader);

        String thirdStringHeader = format(" %-" + lengthLeftPart + "s%s%s%n",
                repeat(UNDERLINE, Integer.toString(model.getDivisionSteps().get(0).getSecondOperand()).length()),
                VERTICAL_LINE, modelQuotient);
        resultHead.append(thirdStringHeader);

        return resultHead.toString();
    }

    private String formBody(List<DivisionStep> divisionSteps, String dividend) {
        StringBuilder resultBody = new StringBuilder();
        String firstOperand = valueOf(divisionSteps.get(0).getFirstOperand());
        String secondOperand = valueOf(divisionSteps.get(0).getSecondOperand());
        String tabulation = parseInt(dividend) < 0 ? SPACE : EMPTY;
        String substractionResult = valueOf(divisionSteps.get(0).getSubstractionResult());
        
        for (int i = 1; i < divisionSteps.size(); i++) {
            if (substractionResult.equals("0")) {
                tabulation = leftPad(tabulation, tabulation.length() + secondOperand.length());
            } else {
                tabulation = leftPad(tabulation,
                        tabulation.length() + secondOperand.length() - substractionResult.length());
            }
            
            if ((divisionSteps.get(i).getSecondOperand() == 0) &&
                    divisionSteps.get(i).getSubstractionResult() == 0) {
                firstOperand = valueOf(divisionSteps.get(i).getFirstOperand());
                resultBody.append(tabulation + SPACE + firstOperand + LF);
                return resultBody.toString();
            }

            firstOperand = valueOf(divisionSteps.get(i).getFirstOperand());
            secondOperand = leftPad(valueOf(divisionSteps.get(i).getSecondOperand()), firstOperand.length());
            substractionResult = valueOf(divisionSteps.get(i).getSubstractionResult());

            resultBody.append(tabulation + MINUS + firstOperand + LF);
            resultBody.append(tabulation + SPACE + secondOperand + LF);
            resultBody.append(tabulation + SPACE + rightPad(EMPTY, secondOperand.length(), UNDERLINE) + LF);
        }

        tabulation = leftPad(tabulation, tabulation.length() + secondOperand.length() - substractionResult.length());
        
        resultBody.append(tabulation + SPACE + substractionResult + LF);
        
        return resultBody.toString();
    }
}
