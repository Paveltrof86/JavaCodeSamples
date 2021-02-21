package com.paveltrofymov.codesamples.division.model;

public class DivisionStep {
    
    private int firstOperand;
    private int secondOperand;
    private int substractionResult;
    
    public DivisionStep(int firstOperand, int secondOperand, int substractionResult) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.substractionResult = substractionResult;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public int getSubstractionResult() {
        return substractionResult;
    }

    public void setSubstractionResult(int substractionResult) {
        this.substractionResult = substractionResult;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + firstOperand;
        result = prime * result + secondOperand;
        result = prime * result + substractionResult;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisionStep other = (DivisionStep) obj;
        if (firstOperand != other.firstOperand)
            return false;
        if (secondOperand != other.secondOperand)
            return false;
        if (substractionResult != other.substractionResult)
            return false;
        return true;
    }
}
