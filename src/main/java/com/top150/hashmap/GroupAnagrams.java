package com.top150.hashmap;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(array);

        list.forEach(System.out::println);

        list = groupAnagrams2(array);
        list.forEach(System.out::println);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            List<String> temp;
            if (map.containsKey(Arrays.toString(charArray))) {
                temp = map.get(Arrays.toString(charArray));
                temp.add(s);
                map.put(Arrays.toString(charArray), temp);
            } else {
                temp = new ArrayList<>();
                temp.add(s);
                map.put(Arrays.toString(charArray), temp);
            }
        }

        return new ArrayList<>(map.values());
    }



    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }

            anagramGroups.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
