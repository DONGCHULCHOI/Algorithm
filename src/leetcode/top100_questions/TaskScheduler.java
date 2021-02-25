package leetcode.top100_questions;

import java.util.Arrays;

public class TaskScheduler {
    // Greedy:
    // T.C: O(n)
    // S.C: O(1)
    // CPU intervals = busy slot + idle slot
    // busy slot = tasks.length
    // the upper limit of idle slot is decided by the most frequent task
    // idle slot <= (maxFreq - 1) * n
    // Fill the idle slot to decrease slot the most, How?
    // Then, Greedy: choose the task in decreasing order of frequency, and take greedy steps filling the slots following the n rule
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26]; // tasks[i] is upper-case English letter
        for(int t : tasks) { // map; (key,value)=(index,frequecy)
            frequencies[t - 'A']++;
        }
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        int idleTime = (maxFreq - 1) * n;

        for(int i = frequencies.length - 2; i >= 0; i--) { // Pick the elements in the descending order one by one
            idleTime = idleTime - Math.min(maxFreq - 1, frequencies[i]); // edge case where the num of tasks is more than the num of the gaps
            // e.g. [A,A,A,B,B,B], n=2, then the last B should be located at the right next to the last A
        }

        idleTime = Math.max(0, idleTime); // edge case: e.g. [A,A,A,B,B,B,C,C,C,D,D,E] -> idleTime get below 0

        return tasks.length + idleTime;
    }
}
