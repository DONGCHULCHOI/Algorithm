package leetcode.amazon_google_questions;

import com.company.ListNode;

public class ReverseNodesInKGroup {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    // T.C: O(N) because do process on n nodes
    // S.C: O(N/k) because of stack, and the recursive tree looks like linear
    public ListNode reverseKGroup(ListNode head, int k) {
        // First, see if there are at least k nodes left in the linked list.
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) { // do count k times on k nodes // *****
            curr = curr.next;
            count++;
        }
        // If we have k nodes, then we reverse them
        if (count == k) {
            // Reverse the first k nodes of the list and get the reversed list's head. // *****
            ListNode reversedHead = reverseList(head, k);

            // head is now at the end of reversed list, curr is at the k+1th pos from 1st node // *****
            // connect the n-1 solution to the head
            head.next = reverseKGroup(curr, k);
            return reversedHead; // base case
        }
        return head; // base case
    }

    public ListNode reverseList(ListNode head, int k) {
        // 206. Reverse Linked List
        // T.C: O(n)
        // S.C: O(1)
        ListNode curr = head; // no dummy Head // *****
        ListNode res = null;

        while(k > 0){ // do reverse op k times // *****
            ListNode next = curr.next; // because curr.next get cut, become other node, we have to remember it
            curr.next = res;
            res = curr;
            curr = next;
            k--; // *****
        }
        return res;

    }
}
