package com.leetCode.password;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    public static List<String> validatePasswords(List<String> passwords, List<String> commonWords) {
        List<String> result = new ArrayList<>();
        for (String password : passwords) {
            boolean isWeak = false;
            if (commonWords.contains(password)) {
                isWeak = true;
            }
            for (String word : commonWords) {
                if (password.contains(word)) {
                    isWeak = true;
                    break;
                }
            }
            if (password.matches("\\d+")) {
                isWeak = true;
            }
            if (password.matches("[A-Z]+") || password.matches("[a-z]+")) {
                isWeak = true;
            }
            if (password.length() < 6) {
                isWeak = true;
            }
            if (isWeak) {
                result.add("weak");
            } else {
                result.add("strong");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> passwords = List.of("hello", "chargeR", "pass123");
        List<String> commonWords = List.of("hello", "123", "password", "xyz", "999");
        List<String> result = validatePasswords(passwords, commonWords);
        for (String passwordResult : result) {
            System.out.println(passwordResult);
        }
    }
}
