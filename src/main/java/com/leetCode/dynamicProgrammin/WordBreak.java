package com.leetCode.dynamicProgrammin;


import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");
        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreak(s, list));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, memo);
    }

    private static boolean wordBreakHelper(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        if (wordSet.contains(s)) {
            memo.put(s, true);
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if (wordSet.contains(left) && wordBreakHelper(right, wordSet, memo)) {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;
    }

}

