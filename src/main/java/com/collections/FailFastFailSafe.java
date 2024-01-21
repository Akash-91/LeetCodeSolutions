package com.collections;

import java.util.*;
import java.util.stream.Stream;

public class FailFastFailSafe {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Iterator<String> iterator = list.iterator();


        // ArrayList

        // fail safe
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("B")) {
                list.remove("B");
            }
        }
        System.out.println(list);

        //fail fast
        for (String element : list) {
            if (element.equals("C")) {
                //  list.remove(element); // Not safe, may throw ConcurrentModificationException
            }
        }
        System.out.println(list);


        // MAP
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Iterator<Map.Entry<String, Integer>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            if (entry.getKey().equals("B")) {
                iterator1.remove(); // Safe removal
                //map.remove(entry.getKey()); // not safe
            }
        }
        System.out.println(map); // Output: {A=1, C=3}

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals("C")) {
                map.remove(entry.getKey()); // Not safe, may throw ConcurrentModificationException
            }
        }
        System.out.println(map);

    }
}
