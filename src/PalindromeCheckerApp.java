// UseCase11PalindromeCheckerApp.java

import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string
        String input = "Deed";

        // Create instance of PalindromeChecker service
        PalindromeChecker checker = new PalindromeChecker();

        boolean isPalindrome = checker.checkPalindrome(input);

        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}

// Service class encapsulating palindrome logic
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String str) {

        if (str == null || str.isEmpty()) {
            return true; // Empty string is considered palindrome
        }

        // Normalize string: ignore case
        String normalized = str.toLowerCase();

        // Use Stack internally
        Stack<Character> stack = new Stack<>();

        // Push all characters to stack
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Pop and compare
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}