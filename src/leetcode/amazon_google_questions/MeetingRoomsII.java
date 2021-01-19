package leetcode.amazon_google_questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        // T.C: O(NlogN) because sorting takes O(NlogN) and in the worst case, do N extract operation, so O(NlogN)
        // S.C: O(N) because construct min heap
        // The priority queue consists of the end time of schedules
        // The size of Priority queue is the number of the meeting rooms
        // 1st. Sort by start time,
        // 2nd. Iterate schedules and check a compatibility using min heaps
        //      if it's not compatible, this means we need a new room, so add it.
        //      if It's compatible, we don't need a new room, remove the top of priority queue and add the one.
        // if we do not use min heap for iterating, then it takes O(N^2) // *****
        if(intervals.length == 0){
            return 0;
        }
        // Sort the intervals by start time // *****
        Arrays.sort(
                intervals,
                new Comparator<int[]>(){
                    public int compare(int[] a, int[] b){
                        return a[0] - b[0];
                    }
                }
        );

        PriorityQueue<Integer> allocator = new PriorityQueue<>(); // default is min heap
        // Add the first meeting for set up
        allocator.add(intervals[0][1]);

        // Iterate schedules and check a compatibility // *****
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.remove();
            }
            allocator.add(intervals[i][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}
