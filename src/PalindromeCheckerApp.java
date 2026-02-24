// UseCase10PalindromeCheckerApp.java

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String original = "A man a plan a canal Panama";

        // Step 1: Normalize string
        String normalized = original.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply two-pointer palindrome logic
        boolean isPalindrome = checkPalindrome(normalized);

        // Step 3: Print result
        if (isPalindrome) {
            System.out.println("The string \"" + original + "\" is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }
    }

    public static boolean checkPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}