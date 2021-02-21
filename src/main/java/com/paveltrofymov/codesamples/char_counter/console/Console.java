package com.paveltrofymov.codesamples.char_counter.console;

import com.paveltrofymov.codesamples.char_counter.services.StringAnalyser;
import com.paveltrofymov.codesamples.char_counter.services.StringAnalyserCacheProxy;

import java.util.Scanner;

public class Console {
    static final String REQUEST_TO_DO = "Enter a string to run the programm:\nor \"ESC\" to exit";
    static final String ESC = "esc";
    static final String ESC_MESSAGE = "Program was terminated by the user!";
    private Scanner scanner;
    private StringAnalyser analyser = new StringAnalyserCacheProxy();

    public Console() {}
    
    public Console(StringAnalyser analyser) {
        this.analyser = analyser;
    }

    public void run() {
        scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMessage(REQUEST_TO_DO);
            String userInputStr = readLine();
            
            exit = isExit(userInputStr);

            if (!exit) {
                String result = analyser.analyse(userInputStr);
                printMessage(result);
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
    
    private boolean isExit(String userInputStr) {
        return userInputStr.equalsIgnoreCase(ESC);
    }
}
