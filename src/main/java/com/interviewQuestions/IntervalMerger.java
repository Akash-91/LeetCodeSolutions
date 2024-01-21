package com.interviewQuestions;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalMerger {

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

    public static void main(String[] args) {
        List<List<Integer>> intervals = Arrays.asList(
                Arrays.asList(7, 7),
                Arrays.asList(2, 3),
                Arrays.asList(6, 11),
                Arrays.asList(1, 2)
        );

        List<List<Integer>> mergedIntervals = getMergedIntervals2(intervals);

        for (List<Integer> interval : mergedIntervals) {
            System.out.println(interval);
        }
    }

    private static List<List<Integer>> getMergedIntervals2(List<List<Integer>> intervals) {

        List<Interval> intervalList = intervals.stream().map(interval -> new Interval(interval.get(0), interval.get(1))).collect(Collectors.toList());
        intervalList.sort(Comparator.comparing(a -> a.start));


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


}