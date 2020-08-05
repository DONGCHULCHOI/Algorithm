package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    // T.C: O(N^2) where N is the number of events booked, do this book opration n times
    // S.C: O(N)
    // Keyword: triple booking, de morgan's law
    // two events [s1, e1) and [s2, e2) do not conflict if and only if one of them starts after the other one ends: either e1 <= s2 OR e2 <= s1
    // By De Morgan's laws, this means the events conflict when s1 < e2 AND s2 < e1
    List<int[]> calendar;
    List<int[]> doubleBooking;
    public MyCalendarII() {
        calendar = new ArrayList<>();
        doubleBooking = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[] elem : doubleBooking){
            if(elem[0] < end && start < elem[1]) // s1 < e2 AND s2 < e1 // check if triple bookikng // the only troubling part is intersection of double booking
                return false;
        }
        for(int[] elem : calendar){
            if(elem[0] < end && start < elem[1]) // s1 < e2 AND s2 < e1 // check if double booking
                doubleBooking.add(new int[]{Math.max(start, elem[0]), Math.min(end, elem[1])}); // *****
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
