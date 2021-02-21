package com.paveltrofymov.codesamples.division.console;

import java.util.Scanner;

import com.paveltrofymov.codesamples.division.services.IntegerDivision;

public class Menu {
    
    static final String REQUEST_OF_DIVIDENT_AND_DIVIDER = "Enter a dividend and divider \nor \"ESC\" to exit";
    static final String EXCEPTION_MESSAGE = "Input is not an int value or wrong format";
    static final String ESC_MESSAGE = "Program was terminated by the user!";
    static final String ESC = "esc";
    private Scanner scanner;
    private IntegerDivision division = new IntegerDivision();
    
    public Menu() {}

    public Menu(IntegerDivision division) {
        this.division = division;
    }

    public void run() {
        scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMessage(REQUEST_OF_DIVIDENT_AND_DIVIDER);

            String userInputDividend = readLine().trim();
            String userInputDivider = readLine().trim();

            exit = isExit(userInputDividend, userInputDivider);

            if (!exit) {
                try {
                    int intDividend = Integer.parseInt(userInputDividend);
                    int intDivider = Integer.parseInt(userInputDivider);
                    String result = division.divide(intDividend, intDivider);
                    printMessage(result);
                } catch (NumberFormatException e) {
                    printMessage(EXCEPTION_MESSAGE);
                }
            } 
        }
        printMessage(ESC_MESSAGE);
        scanner.close();
    }

    //use package-private modifier to run junit tests
    /*private*/ void printMessage(String message) {
        System.out.println(message);
    }

    //use package-private modifier to run junit tests
    /*private*/ String readLine() {
        return scanner.nextLine();
    }

    private boolean isExit(String inputDivident, String InputDivider) {
        return inputDivident.equalsIgnoreCase(ESC) || InputDivider.equalsIgnoreCase(ESC);
    }
}
