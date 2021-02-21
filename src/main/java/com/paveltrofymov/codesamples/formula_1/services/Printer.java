package com.paveltrofymov.codesamples.formula_1.services;

public class Printer {
    private ReportProvider resultProvider = new ReportProvider();
    
    public Printer() {}
    
    public Printer(ReportProvider resultProvider) {
        this.resultProvider = resultProvider;
    }
    
    public void print() {
        String result = resultProvider.provide();
        printMessage(result);
    }
    
    private void printMessage(String result) {
        System.out.println(result);
    }
}
