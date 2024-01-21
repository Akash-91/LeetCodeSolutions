package com.sorting;

import java.util.*;

public class HashMapSorting {

    public static void main(String[] args) {
        HashMap<Integer, String> unsortedMap = new HashMap<>();
        unsortedMap.put(3, "Three");
        unsortedMap.put(1, "One");
        unsortedMap.put(2, "Two");
        // Convert to a List of Map.Entry objects
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(unsortedMap.entrySet());
        // Sort the list by keys
        Collections.sort(entryList, Map.Entry.comparingByKey());

        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>(); // Create a new LinkedHashMap to store the sorted entries
        for (Map.Entry<Integer, String> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        // Display the sorted map
        System.out.println(sortedMap);


        // Convert to a List of Map.Entry objects
        List<Map.Entry<Integer, String>> entryList2 = new ArrayList<>(unsortedMap.entrySet());
        // Sort the list by values
        entryList2.sort(Comparator.comparing(Map.Entry::getValue));

        LinkedHashMap<Integer, String> sortedMap2 = new LinkedHashMap<>();// Create a new LinkedHashMap to store the sorted entries
        for (Map.Entry<Integer, String> entry : entryList2) {
            sortedMap2.put(entry.getKey(), entry.getValue());
        }

        // Display the sorted map
        System.out.println(sortedMap2);
    }
}



