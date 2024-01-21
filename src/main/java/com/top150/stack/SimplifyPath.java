package com.top150.stack;

import java.util.Stack;

public class SimplifyPath {


    public static void main(String[] args) {
        // Example usage:
        String path1 = "/home/";
        String path2 = "/a/./b/./c/";

        String output1 = simplifyPath(path1);
        String output2 = simplifyPath(path2);

        System.out.println(output1);  // Output: "/home"
        System.out.println(output2);  // Output: "/c"
    }


    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");

        for (String directory : directories) {
            if (directory.equals(".") || directory.isEmpty()) {
                // Ignore current directory "." and empty strings
                continue;
            } else if (directory.equals("..")) {
                // Move up a level by popping the top directory from the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push valid directory onto the stack
                stack.push(directory);
            }
        }

        // Construct simplified canonical path by joining directories in the stack
        StringBuilder simplifiedPath = new StringBuilder("/");
        while (!stack.isEmpty()) {
            simplifiedPath.insert(1, stack.pop());
            if (!stack.isEmpty()) {
                simplifiedPath.insert(1, "/");
            }
        }

        return simplifiedPath.toString();
    }


    public String simplifyPath2(String path) {
        Stack<Character> stack = new Stack<>();
        StringBuffer sbf = new StringBuffer();

        for (int i = 0; i < path.length(); i++) {

            char currentChar = path.charAt(i);

            if (stack.isEmpty() && currentChar == '/') {
                stack.push(currentChar);
            }
            if (currentChar == '/' && !stack.isEmpty() && stack.peek() != '/') {
                stack.push(currentChar);
            } else if (currentChar == '.' && !stack.isEmpty() && stack.peek() != '.') {
                stack.push(currentChar);
            } else if (currentChar != '.' && currentChar != '/') {
                stack.push(currentChar);
            }
        }

        if (!stack.isEmpty() && stack.peek() == '/') {
            stack.pop();
        }

        if (stack.peek() == '.') {
            stack.pop();
            if (stack.peek() == '.') {
                stack.pop();
            }
        }


        for (Character character : stack) {
            sbf.append(character);

        }
        return sbf.toString();
    }
}

