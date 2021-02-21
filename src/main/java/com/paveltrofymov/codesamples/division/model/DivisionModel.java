package com.paveltrofymov.codesamples.division.model;

import java.util.ArrayList;
import java.util.List;

public class DivisionModel {
    
    private String dividend;
    private String divisor;
    private String quotient;
    private List<DivisionStep> divisionSteps = new ArrayList<>();
    
    public DivisionModel(String dividend, String divisor, String quotient) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
    }
    
    public DivisionModel() {}
    
    public String getDividend() {
        return dividend;
    }
    public void setDividend(String dividend) {
        this.dividend = dividend;
    }
    public String getDivisor() {
        return divisor;
    }
    public void setDivisor(String divisor) {
        this.divisor = divisor;
    }
    public String getQuotient() {
        return quotient;
    }
    public void setQuotient(String quotient) {
        this.quotient = quotient;
    }
    public List<DivisionStep> getDivisionSteps() {
        return divisionSteps;
    }
    public void setDivisionSteps(List<DivisionStep> divisionSteps) {
        this.divisionSteps = divisionSteps;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dividend == null) ? 0 : dividend.hashCode());
        result = prime * result + ((divisionSteps == null) ? 0 : divisionSteps.hashCode());
        result = prime * result + ((divisor == null) ? 0 : divisor.hashCode());
        result = prime * result + ((quotient == null) ? 0 : quotient.hashCode());
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
        DivisionModel other = (DivisionModel) obj;
        if (dividend == null) {
            if (other.dividend != null)
                return false;
        } else if (!dividend.equals(other.dividend))
            return false;
        if (divisionSteps == null) {
            if (other.divisionSteps != null)
                return false;
        } else if (!divisionSteps.equals(other.divisionSteps))
            return false;
        if (divisor == null) {
            if (other.divisor != null)
                return false;
        } else if (!divisor.equals(other.divisor))
            return false;
        if (quotient == null) {
            if (other.quotient != null)
                return false;
        } else if (!quotient.equals(other.quotient))
            return false;
        return true;
    }   
}
