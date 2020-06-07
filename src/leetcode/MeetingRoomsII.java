package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        // Sort by start time, then iterate using min heaps based on end time
        // if we do not use min heap for iterating, then it takes O(N^2)
        // T.C: O(NlogN) because sorting takes O(NlogN) and in the worst case, do N extract operation, so O(NlogN)
        // S.C: O(N) because construct min heap
        if(intervals.length == 0){
            return 0;
        }

        // Min heap // *****
        PriorityQueue<Integer> allocator = new PriorityQueue<>(
                intervals.length,
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return a-b;
                    }
                }
        );

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>(){ // ****
                    public int compare(int[] a, int[] b){
                        return a[0] - b[0];
                    }
                }
        );

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals // *****
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) { // = -> e.g. [1,10], [10,15] => can allocate [10, 15] right after [1,10]
                allocator.remove(); // extract operation
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]); // insert operation
        }
        // The size of the heap tells us the minimum rooms required for all the meetings. // *****
        return allocator.size();
    }
}
