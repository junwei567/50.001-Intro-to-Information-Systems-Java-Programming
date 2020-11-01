package pset2A;

public class TestPalindrome {
    public static void main(String[] args) {

        char[] S = {'a','b','c','a'};
        Palindrome P = new Palindrome();
        if(Palindrome.isPalindrome(S)) System.out.println("Is Palindrome");
        else System.out.println("Not Palindrome");
    }
}
