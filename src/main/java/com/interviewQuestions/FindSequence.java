package com.interviewQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FindSequence {

    public static void main(String[] args) {


        String input1 = "1 2 3 a 4 5 6 @ ! 6 4 2 -3 -2 8 9 10 11 # 65 % 64 65";
        String input2 = "1 2 3 a 4 5 6";

        printList(findNumberSequences(input1));

        printList(findNumberSequences2(input2));
    }


    public static List<String> findNumberSequences2(String input) {
        String[] splitInput = input.split(" ");
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        Integer previous = null;
        for (String s : splitInput) {
            try {
                Integer current = Integer.parseInt(s);
                if (previous != null && (current - previous) == 1) {
                    sequence.add(current);
                } else {
                    if (sequence.size() > 1) {
                        sequences.add(new ArrayList<>(sequence));
                    }
                    sequence.clear();
                    sequence.add(current);
                }
                previous = current;
            } catch (Exception e) {
                if (sequence.size() > 1) {
                    sequences.add(new ArrayList<>(sequence));
                }
                previous = null;
                sequence.clear();
            }
        }
        if (sequence.size() > 1) {
            sequences.add(sequence);
        }
        return sequences.stream().map(
                        integers -> integers.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(",")))
                .collect(Collectors.toList());
    }

    public static List<String> findNumberSequences(String input) {

        String[] splitInput = input.split(" ");

        List<Integer> sequence = new ArrayList<>();
        List<List<Integer>> sequences = new ArrayList<>();
        Integer previous = null;
        for (String s : splitInput) {
            try {
                Integer current = Integer.parseInt(s);
                if (null != previous) {
                    if ((current - previous) == 1) {
                        sequence.add(current);
                    } else {

                        if (sequence.size() > 1) {
                            sequences.add(sequence);
                        }
                        sequence = new ArrayList<>();
                        sequence.add(current);
                    }
                    previous = current;
                } else {
                    previous = current;
                    sequence.add(current);
                }
            } catch (Exception e) {
                if (sequence.size() > 1) {
                    sequences.add(sequence);
                }
                previous = null;
                sequence = new ArrayList<>();
            }
        }
        if (sequence.size() > 1) {
            sequences.add(sequence);
        }
        return sequences.stream().map(list -> list.stream().map(String::valueOf).collect(Collectors.joining(","))).collect(Collectors.toList());

    }


    private static void printList(List<String> sequences) {
        sequences.forEach(System.out::println);
        System.out.println("=--=-=-=-=-=-=-=-");
    }
}
