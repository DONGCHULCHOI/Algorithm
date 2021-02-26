package leetcode.top100_questions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    // Heap:
    // T.C: O(NlogN) because sorting takes O(NlogN) and in the worst case, do N extract operation, so O(NlogN)
    // S.C: O(N) because construct min heap
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        // Sort the intervals by start time // *****
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Always think element in array

        PriorityQueue<Integer> allocator = new PriorityQueue<>(); // default is min heap
        allocator.add(intervals[0][1]); // Add the first meeting's finish time for set up

        // Iterate schedules and check a compatibility // *****
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) { // next meeting's start time >= previous meeting's end time -> can merge previous and next meeting room
                allocator.remove();
            }
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}
