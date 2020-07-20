package leetcode;

import com.company.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    // Next time get used to Lambda expression of Comparator
    // T.C: O(N log K) where N is the total number of nodes and K is the size of lists
    // S.C: O(K) which is the cost of building the priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        //PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>( // min heap
                lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        }
        );

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()){
            curr.next = queue.remove();
            curr = curr.next;

            if (curr.next!=null)
                queue.add(curr.next);
        }
        return dummy.next;
    }
}
