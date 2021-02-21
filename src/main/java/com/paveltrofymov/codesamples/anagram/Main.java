package com.paveltrofymov.codesamples.anagram;

public class Main {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        new Menu(anagram).run();
    }
}
