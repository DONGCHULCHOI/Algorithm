package leetcode.amazon_google_questions;

import com.company.ListNode;

public class ReverseLinkedList {
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
    public ListNode reverseList(ListNode head) {
        // T.C: O(n)
        // S.C: O(1)
        ListNode curr = head; // no dummy Head // *****
        ListNode res = null;

        while(curr != null){
            ListNode next = curr.next; // because curr.next get cut, become other node, we have to remember it
            curr.next = res;
            res = curr;
            curr = next;
        }
        return res;
    }
}
