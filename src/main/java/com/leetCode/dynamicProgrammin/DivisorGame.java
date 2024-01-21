package com.leetCode.dynamicProgrammin;


/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * Also, if a player cannot make a move, they lose the game.
 * <p>
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 */
public class DivisorGame {


    public static void main(String[] args) {

        int n = 6;
        didAliceWin(n);
    }


    // alice : 1,2,3
    private static void didAliceWin(int n) {

        int moves[] = new int[n];
        int newN[] = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                moves[j] = i;
                newN[j] = n - i;

                j++;
            }
        }


        for (int i : moves) {
            System.out.print(i + ", ");
        }
        System.out.println();
        for (int i : newN) {
            System.out.print(i + ", ");
        }

    }
}
