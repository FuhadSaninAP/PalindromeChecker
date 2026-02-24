// UseCase7PalindromeCheckerApp.java

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string
        String original = "noon";

        // Create Deque
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (int i = 0; i < original.length(); i++) {
            deque.addLast(original.charAt(i));  // Insert at rear
        }

        boolean isPalindrome = true;

        // Compare front and rear until deque size is <= 1
        while (deque.size() > 1) {

            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("The string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }
    }
}