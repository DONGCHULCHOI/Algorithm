package leetcode.top100_questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    // Greedy:
    // O(n^2)
    // O(n)
    // Find the reconstructed queue
    // Choose the highest guy, if the height is same, then choose the guy based on the increasing order of k,
    // take greedy steps locating the guy at the index of the k value of the guy(if someone is on the index k, he and subsequent guys are moved to right)
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() { // think each element of the array, that's type of Comparator, and parameter of compare method // *****
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]; // decreasing order : increasing order
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] person : people) {
            output.add(person[1], person);
        }

        return output.toArray(new int[people.length][2]);
    }
}
