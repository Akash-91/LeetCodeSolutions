package com.top150.arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < commonPrefix.length() && j < strs[i].length() && commonPrefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // Update commonPrefix to keep only the matching characters
            commonPrefix = commonPrefix.substring(0, j);
            // If commonPrefix becomes an empty string, no need to check further
            if (commonPrefix.isEmpty()) {
                break;
            }
        }
        return commonPrefix;
    }
}
