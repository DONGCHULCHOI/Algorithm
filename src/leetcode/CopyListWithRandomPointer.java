package leetcode;

import com.company.Node;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // T.C: O(N)
        // S.C: O(1) // *1) // *****
        if(head == null){
            return null;
        }

        Node curr = head; // head is not dummy head
        while(curr != null){ // make weaved linked list // *****
            Node newNode = new Node(curr.val); // deep clone
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head; // back to head again
        while(curr != null){ // set random curr for the clone // *****
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        Node currOldList = head; // *****
        Node currNewList = head.next; // *****
        Node headNew = head.next; // ***
        while(currOldList != null){ // *****
            // unweave the clone of the curr node and weave the next node of the curr of the old list
            currOldList.next = currOldList.next.next;
            // unweave the original of the curr node and weave the next node of the curr of the old list
            currNewList.next = (currNewList.next != null) ? currNewList.next.next : null;

            currOldList = currOldList.next; // update curr of old list
            currNewList = currNewList.next; // update curr of new list
        }
        return headNew;
    }
    // 1) this deep clone does not be included in S.C because it is just for the return, not related to needed extra space by the alogrithm related to input
}
