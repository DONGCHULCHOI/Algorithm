package leetcode.amazon_google_questions;

import com.company.ListNode;

public class AddTwoNumbers {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // T.C: O(max(m,n)) where m and n represents the length of l1 and l2 respectively
        // S.C: O(max(m,n)) because The length of the new list is at most max(m,n)+1
        ListNode dummyHead = new ListNode(); // to return the result easily // ***
        ListNode curr = dummyHead;
        int carry = 0; //for the case of ten digits as a result of sum of the position // *****

        while(l1 != null || l2 != null){ // till either one of them finish // *****
            int x = (l1 != null) ? l1.val : 0; // in the case of one of them is shorter
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y; // *****
            carry = sum / 10; // *****
            curr.next = new ListNode(sum % 10); // *****
            curr = curr.next;
            if(l1 != null)  l1 = l1.next;
            if(l2 != null)  l2 = l2.next;
        }
        if(carry > 0){ // for the last digits // *****
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
