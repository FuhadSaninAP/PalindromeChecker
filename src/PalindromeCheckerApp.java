// UseCase12PalindromeCheckerApp.java

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack-based implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {

        if (str == null || str.isEmpty()) return true;

        String normalized = str.toLowerCase().replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque-based implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {

        if (str == null || str.isEmpty()) return true;

        String normalized = str.toLowerCase().replaceAll("\\s+", "");
        Deque<Character> deque = new LinkedList<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String str) {
        return strategy.isPalindrome(str);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Able was I ere I saw Elba";

        PalindromeContext context = new PalindromeContext();

        // Choose Stack Strategy dynamically
        context.setStrategy(new StackStrategy());
        boolean resultStack = context.executeStrategy(input);
        System.out.println("Stack Strategy: \"" + input + "\" → " + (resultStack ? "Palindrome" : "Not Palindrome"));

        // Choose Deque Strategy dynamically
        context.setStrategy(new DequeStrategy());
        boolean resultDeque = context.executeStrategy(input);
        System.out.println("Deque Strategy: \"" + input + "\" → " + (resultDeque ? "Palindrome" : "Not Palindrome"));
    }
}