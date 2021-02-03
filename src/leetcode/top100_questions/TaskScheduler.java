package leetcode.top100_questions;

import java.util.Arrays;

public class TaskScheduler {
    // T.C: O(n)
    // S.C: O(1)
    // Greedy:
    // CPU intervals = busy slot + idle slot
    // busy slot = tasks.length
    // idle slot is decided by the most frequenct task
    // idle slot <= (maxFreq - 1) * n
    // Then, decrease idle slots using Greedy: fill the slots with the frequent task in decreasing order
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26]; // tasks[i] is upper-case English letter
        for(int t : tasks) { // map; (key,value)=(index,frequecy)
            frequencies[t - 'A']++;
        }

        Arrays.sort(frequencies);

        int maxFreq = frequencies[25];
        int idleTime = (maxFreq - 1) * n;

        for(int i = frequencies.length - 2; i >= 0 && idleTime >= 0; i--) { // Pick the elements in the descending order one by one
            idleTime = idleTime - Math.min(maxFreq - 1, frequencies[i]); // edge case: [A,A,A,B,B,B], n=2, then the last B should be located at the right next to the last A
        }

        idleTime = Math.max(0, idleTime); // edge case: n = 0

        return tasks.length + idleTime;
    }
}
