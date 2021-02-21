package com.paveltrofymov.codesamples.anagram;

import static java.lang.Character.isAlphabetic;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;


public class Anagram {
    static final String EXCEPTION_MESSAGE = "Invoking a method with a null parametr";
    
    public String reverseString(String inputString){
        
        if (inputString == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        
        String[] words = inputString.split(SPACE);

        for (int i = 0; i < words.length; i++) {
            if (isNotBlank(words[i])) {
                words[i] = reverseWord(words[i]);
            }
        }
        return String.join(SPACE, words);
    }

    String reverseWord(String word) {
        char[] chars = word.toCharArray();
        int right = chars.length - 1;
        int left = 0;

        while (left < right) {
            if (!isAlphabetic(chars[left])) {
                left++;
            } else if (!isAlphabetic(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
