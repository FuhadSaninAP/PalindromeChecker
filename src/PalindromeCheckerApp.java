// UseCase13PalindromeCheckerApp.java

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String testString = "A man a plan a canal Panama";

        // Normalize string
        String normalized = testString.replaceAll("\\s+", "").toLowerCase();

        // Run and time Stack-based approach
        long startStack = System.nanoTime();
        boolean resultStack = stackPalindrome(normalized);
        long endStack = System.nanoTime();
        long durationStack = endStack - startStack;

        // Run and time Deque-based approach
        long startDeque = System.nanoTime();
        boolean resultDeque = dequePalindrome(normalized);
        long endDeque = System.nanoTime();
        long durationDeque = endDeque - startDeque;

        // Run and time Two-pointer approach
        long startTwoPointer = System.nanoTime();
        boolean resultTwoPointer = twoPointerPalindrome(normalized);
        long endTwoPointer = System.nanoTime();
        long durationTwoPointer = endTwoPointer - startTwoPointer;

        // Display results
        System.out.println("Palindrome Performance Comparison for: \"" + testString + "\"");
        System.out.println("---------------------------------------------------------");
        System.out.println("Stack-based: " + resultStack + " | Time: " + durationStack + " ns");
        System.out.println("Deque-based: " + resultDeque + " | Time: " + durationDeque + " ns");
        System.out.println("Two-pointer: " + resultTwoPointer + " | Time: " + durationTwoPointer + " ns");
    }

    // Stack-based palindrome
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Deque-based palindrome
    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // Two-pointer palindrome
    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}