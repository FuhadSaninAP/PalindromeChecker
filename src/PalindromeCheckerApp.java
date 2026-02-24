// UseCase9PalindromeCheckerApp.java

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String original = "madam";

        boolean isPalindrome = checkPalindrome(original, 0, original.length() - 1);

        if (isPalindrome) {
            System.out.println("The string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }
    }

    // Recursive method
    public static boolean checkPalindrome(String str, int start, int end) {

        // Base condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return checkPalindrome(str, start + 1, end - 1);
    }
}