package leetcode;

import com.company.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // T.C: O(n)
        // S.C: O(1)
        ListNode curr = head; // no dummy Head // ***
        ListNode res = null;

        while(curr != null){
            ListNode nextTemp = curr.next; // mark the next node of curr
            curr.next = res; // link curr node to res
            res = curr; // update res pos
            curr = nextTemp; // update curr pos
        }
        return res;
    }
}
