package pset2A;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome (char[] S) {

        if (S.length == 0 || S.length == 1) return true;
        else if (S[0] == S[S.length - 1]) {
            return isPalindrome(Arrays.copyOfRange(S, 1, S.length -1));
        }
        else return false;

    }
}
