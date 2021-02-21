package com.paveltrofymov.codesamples.anagram;

import java.util.Scanner;

public class Menu {
    static final String REQUEST_TO_DO = "Enter a string to run the programm:\nor \"ESC\" to exit";
    static final String ESC = "esc";
    private Scanner scanner;
    private Anagram anagram;
    
    public Menu(Anagram anagram) {
        this.anagram = anagram;
    }

    public void run() {
        scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMessage(REQUEST_TO_DO);
            String userInputStr = readLine();

            if (userInputStr.equalsIgnoreCase(ESC)) {
                exit = true;
                scanner.close();
            } else {
                String result = anagram.reverseString(userInputStr);
                printMessage(result); 
            }
        }
    }
    //use package-private modifier to run junit tests
    /*private*/ void printMessage(String message) {
        System.out.println(message);
    }

    //use package-private modifier to run junit tests
    /*private*/ String readLine() {
        return scanner.nextLine();
    }
}
