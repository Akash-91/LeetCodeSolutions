package com.leetCode.arrays;

import java.util.*;

class Result {

    public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals) {
        List<Interval> intervalList = new ArrayList<>();

        for (List<Integer> interval : intervals) {
            intervalList.add(new Interval(interval.get(0), interval.get(1)));
        }

        intervalList.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> result = new ArrayList<>();
        Interval current = intervalList.get(0);

        for (int i = 1; i < intervalList.size(); i++) {
            if (current.end >= intervalList.get(i).start) {
                current.end = Math.max(current.end, intervalList.get(i).end);
            } else {
                result.add(current);
                current = intervalList.get(i);
            }
        }

        result.add(current);

        List<List<Integer>> mergedIntervals = new ArrayList<>();
        for (Interval interval : result) {
            mergedIntervals.add(Arrays.asList(interval.start, interval.end));
        }

        return mergedIntervals;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

public class Solution {
    public static void main(String[] args) {

        {
            List<List<Integer>> intervals = Arrays.asList(
                    Arrays.asList(7, 7),
                    Arrays.asList(2, 3),
                    Arrays.asList(6, 11),
                    Arrays.asList(1, 2)
            );

            List<List<Integer>> mergedIntervals = Result.getMergedIntervals(intervals);

            for (List<Integer> interval : mergedIntervals) {
                System.out.println(interval);
            }
        }

    }
}
