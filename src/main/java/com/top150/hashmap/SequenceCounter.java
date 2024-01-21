package com.top150.hashmap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SequenceCounter {
    int currLength;
    int head;
    int tail;

    public SequenceCounter(int num) {
        this.currLength = 1;
        this.head = num;
        this.tail = num;
    }

    public void newHead(int num) {
        this.head = num;
        this.currLength++;
    }

    public void newTail(int num) {
        this.tail = num;
        this.currLength++;
    }

    // Assumes that the supplied sequence counter will be
    // appended to the back of 'this' instance sequence
    // Also assumes the merge is on a common number that can be both a
    // head and a tail for two different sequence counters
    public void merge(SequenceCounter sequenceCounter) {
        int tail = sequenceCounter.tail;
        int currentLength = this.currLength;

        this.currLength = currentLength + sequenceCounter.currLength + 1;
        this.tail = tail;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        // Empty array edge case
        if (nums.length == 0) return 0;

        int currLongestSequence = 1;

        Map<Integer, SequenceCounter> headMap = new HashMap<>();
        Map<Integer, SequenceCounter> tailMap = new HashMap<>();
        Set<Integer> viewedNums = new HashSet<>();

        for (int num : nums) {
            if (viewedNums.contains(num)) {
                continue;
            }

            SequenceCounter currCounterInstance;
            SequenceCounter validHeadCounter = headMap.get(num - 1);
            SequenceCounter validTailCounter = tailMap.get(num + 1);

            if (validHeadCounter != null && validTailCounter != null) {
                validTailCounter.merge(validHeadCounter);

                headMap.remove(num - 1);
                tailMap.remove(num + 1);

                headMap.put(validTailCounter.head, validTailCounter);
                tailMap.put(validTailCounter.tail, validTailCounter);

                currCounterInstance = validTailCounter;
            } else if (validHeadCounter != null) {
                validHeadCounter.newHead(num);

                headMap.remove(num - 1);
                headMap.put(validHeadCounter.head, validHeadCounter);

                currCounterInstance = validHeadCounter;
            } else if (validTailCounter != null) {
                validTailCounter.newTail(num);

                tailMap.remove(num - 1);
                tailMap.put(validTailCounter.tail, validTailCounter);

                currCounterInstance = validTailCounter;
            } else {
                SequenceCounter sequenceCounter = new SequenceCounter(num);
                int head = sequenceCounter.head;
                int tail = sequenceCounter.tail;

                headMap.put(head, sequenceCounter);
                tailMap.put(tail, sequenceCounter);

                currCounterInstance = sequenceCounter;
            }

            if (currCounterInstance.currLength > currLongestSequence) {
                currLongestSequence = currCounterInstance.currLength;
            } //compares each created or mutated counter to the currently recorded longest sequence

            viewedNums.add(num); // Regardless of the outcome, set the current number as a viewed number
        }

        return currLongestSequence;
    }
}
