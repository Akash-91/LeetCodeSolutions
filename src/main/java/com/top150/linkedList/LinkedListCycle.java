package com.top150.linkedList;

class ListNode1 {
    int val;
    ListNode next;

    ListNode1(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Example 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Creating a cycle
        int pos1 = 1;
        System.out.println(solution.hasCycle(head1)); // Output: true
    }
}
