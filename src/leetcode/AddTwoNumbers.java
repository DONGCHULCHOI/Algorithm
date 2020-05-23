package leetcode;

import com.company.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // T.C: O(max(m,n)) where m and n represents the length of l1 and l2 respectively
        // S.C: O(max(m,n)) because The length of the new list is at most max(m,n)+1
        ListNode dummyHead = new ListNode(); // to return the result easily // ***
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0; //for the case of overflow // *****

        while(p != null || q != null){ // till either one of them finish // ***
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y; // *****
            carry = sum / 10; // *****
            curr.next = new ListNode(sum % 10); // *****
            curr = curr.next;
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        if(carry > 0){ // for the last digits // ***
            curr.next = new ListNode(carry);
        }
        return dummyHead.next; // ***
    }
}
