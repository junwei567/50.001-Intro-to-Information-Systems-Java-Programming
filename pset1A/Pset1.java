package com.example.lib001;

public class Pset1 {
    public static boolean isAllCharacterUnique (String sIn) {
        for (int i = 0; i < sIn.length() - 1; i++) {
            if (sIn.charAt(i) == sIn.charAt(i + 1)) return false;
        }
        return true;
    }
    public static boolean isPermutation(String sIn1, String sIn2){
       if (sIn1.length() != sIn2.length()) {
           return false;
       }
       for (int i=0; i < sIn1.length(); i++) {
           if (sIn2.indexOf(sIn1.charAt(i)) == -1 ) return false;
       }
       return true;
    }
}
