package com.top150.stack;

import java.util.*;

public class ValidParentheses {


    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

        s = "]";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> openingSet = new HashSet<>(Arrays.asList('(', '{', '['));
        Set<Character> closingSet = new HashSet<>(Arrays.asList(')', '}', ']'));

        for (char currentChar : s.toCharArray()) {
            if (openingSet.contains(currentChar)) {
                stack.push(currentChar);
            } else if (closingSet.contains(currentChar)) {
                if (!stack.isEmpty() && isMatching(stack.peek(), currentChar)) {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }


    /**
     * (', ')', '{', '}', '[' and ']'
     *
     * @param s
     * @return
     */

    public static boolean isValid2(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                stack.push(String.valueOf(currentChar));
            } else if (currentChar == ')') {
                if (!stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else
                    stack.push(String.valueOf(currentChar));
            }

            if (currentChar == '{') {
                stack.push(String.valueOf(currentChar));
            } else if (currentChar == '}') {
                if (!stack.isEmpty() && stack.peek().equals("{"))
                    stack.pop();
                else
                    stack.push(String.valueOf(currentChar));
            }
            if (currentChar == '[') {
                stack.push(String.valueOf(currentChar));
            } else if (currentChar == ']') {
                if (!stack.isEmpty() && stack.peek().equals("["))
                    stack.pop();
                else
                    stack.push(String.valueOf(currentChar));
            }

        }

        return stack.isEmpty();
    }
}
