package leetcode.amazon_google_questions;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    // T.C: O(log n)
    // S.C: O(n)
    // make two priority queue, store half element in each priority queue // *****
    // smaller numbers are stored in 'small' priority queue which is max heap // *****
    // larger numbers are stored in 'large' priority queue which is min heap // *****
    // when the number of 'large' priority queue is bigger, it means the number of tot number of inputs is odd, then it self is median
    // the opposite, it means the number of tot number of inputs is even, then have to extract max in 'small' and extract min in 'large'
    // then sum these two and divide it by 2.0
    // To avoid overflow, use Long type priority queue // *****
    private PriorityQueue<Long> small;
    private PriorityQueue<Long> large;

    public FindMedianFromDataStream() {
        small = new PriorityQueue<>((a,b) -> (b.compareTo(a))); // Max heap
        large = new PriorityQueue<>(); // Min heap
    }

    public void addNum(int num) {
        large.add((long)num);
        small.add(large.remove());
        if(large.size() < small.size())
            large.add(small.remove());
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
