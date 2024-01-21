package com.interviewQuestions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindSequenceTest {

    String input1 = "1 2 3 a 4 5 6 @ ! 6 4 2 -3 -2 % 64 65";
    String input2 = "1 2 3 a 4 5 6";


    @Test
    void main() {
        List<String> expectedOutput1 = List.of("1,2,3", "4,5,6", "-3,-2", "64,65");
        assertEquals(FindSequence.findNumberSequences(input1), expectedOutput1);

        List<String> expectedOutput2 = List.of("1,2,3", "4,5,6");
        assertEquals(FindSequence.findNumberSequences(input2), expectedOutput2);
    }
}