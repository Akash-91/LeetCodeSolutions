package com.leetCode.assessment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SendEmail {

    Set<String> set = new HashSet<>();

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        Arrays.stream(emails)
                .map(email -> {
                    String[] parts = email.split("@");
                    String localName = parts[0].split("\\+")[0].replace(".", "");
                    return localName + "@" + parts[1];
                })
                .forEach(set::add);
        return set.size();
    }

    public static void main(String[] args) {


        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};

        SendEmail sendEmail = new SendEmail();

        System.out.println(sendEmail.numUniqueEmails(emails));

    }
}
