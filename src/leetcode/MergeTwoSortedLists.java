package leetcode;

import com.company.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        // recursion
        // T.C: O(n+m) because there will be exactly one call to mergeTwoLists per element in each list
        // S.C: O(n+m) because n+m stack frames consume O(n+m) space.
        if(l1 == null){
            return l2; // ***
        }
        if(l2 == null){
            return l1; // ***
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2); // *****
            return l1; // *****
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next); // *****
            return l2; // *****
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // iteration
        // T.C: O(n+m)
        // S.C: O(1)
        ListNode dummyHead = new ListNode(); // *****
        ListNode curr = dummyHead;
        while(l1 != null && l2 != null){ // *****
            if(l1.val < l2.val){ // *****
                curr.next = l1;
                l1 = l1.next;
            }
            else{ // *****
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null) ? l2 : l1; // *****
        return dummyHead.next;
    }
}
