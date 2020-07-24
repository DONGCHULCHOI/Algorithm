package leetcode;

import com.company.ListNode;

public class RemoveNthNodeFromEndOfList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // T.C: O(L) because The algorithm makes one traversal of the list of L nodes
        // S.C: O(1)
        // keep distance n nodes between first and second ptrs // *****
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Advances first pointer so that the gap between first and second is n nodes apart
        for(int i=1; i<=n+1; i++){ // the index because of dummy head
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while(first != null){
            first = first.next;
            second = second.next;
        }
        // remove the n th node from the end
        second.next = second.next.next;
        return dummy.next;
    }
}
