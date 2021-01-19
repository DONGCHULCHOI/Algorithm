package leetcode.amazon_google_questions;

import com.company.Node;

public class CopyListWithRandomPointer {
    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */
    public Node copyRandomList(Node head) {
        // T.C: O(N)
        // S.C: O(N)
        // Step1. Iterate and make the clone, place it to the original node
        // Step2. Assign random pointer of the clone using the random pointer of the original node
        // Step3. After intertwining the nodes, Unweave
        if(head == null){
            return null;
        }

        Node curr = head; // Step1 // *****
        while(curr != null){
            Node newNode = new Node(curr.val); // deep clone
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head; // Step2 // *****
        while(curr != null){
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }
        // Step3 // *****
        Node currOld = head; // *****
        Node currNew = head.next; // *****
        Node headNew = currNew; // ***
        while(currOld != null){ // *****
            currOld.next = currOld.next.next; // there is no worry to point null // *****
            currNew.next = (currNew.next != null) ? currNew.next.next : null; // e.g. currNew -> currOld -> null // *****

            currOld = currOld.next;
            currNew = currNew.next;
        }
        return headNew;
    }
}
