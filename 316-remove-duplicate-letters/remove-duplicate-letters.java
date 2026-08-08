import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]--; // Decrement available count for character 'c'

            // If character is already in stack, skip to avoid duplicates
            if (inStack[index]) {
                continue;
            }

            // Maintain lexicographically smallest order:
            // Pop characters that are greater than 'c' IF they appear later in 's'
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }

            stack.push(c);
            inStack[index] = true;
        }

        // Build result string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}