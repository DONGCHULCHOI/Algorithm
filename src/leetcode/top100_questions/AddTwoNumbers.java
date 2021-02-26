package leetcode.top100_questions;

import com.company.ListNode;

public class AddTwoNumbers {
    // List:
    // T.C: O(max(m,n)) where m and n represents the length of l1 and l2 respectively
    // S.C: O(max(m,n)) because The length of the new list is at most max(m,n)+1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(); // *****
        ListNode curr = dummyHead; // *****

        int carry = 0;

        while(l1 != null || l2 != null){ // until reach both ends // *****
            int x = (l1 != null) ? l1.val : 0; // for the case where one of the list reached first // *****
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y; // ***
            carry = sum / 10; // ***
            curr.next = new ListNode(sum % 10); // ***
            curr = curr.next;

            if(l1 != null)  l1 = l1.next; // for the case where one of the list reached first // *****
            if(l2 != null)  l2 = l2.next;
        }
        if(carry > 0){ // for the last digits // *****
            curr.next = new ListNode(carry);
        }
        return dummyHead.next; // *****
    }
}
