package leetcode.top100_questions;

import com.company.ListNode;

public class MergeTwoSortedLists {
    // Recursion:
    // T.C: O(n+m) because there will be exactly one call to mergeTwoLists per element in each list, and the recursive tree is just one branch
    // S.C: O(n+m) because n+m stack frames consume O(n+m) space.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) { // *****
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else { // *****
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
