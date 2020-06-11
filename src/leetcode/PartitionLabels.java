package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        // Greedy
        // repeatedly choose the smallest left-justified partition
        // Consider the first label, say it's 'a'. The first partition must include it, and also the last occurrence of 'a'
        // However, between those two occurrences of 'a', there could be other labels that make the minimum size of this partition bigger
        // For each letter encountered, process the last occurrence of that letter, extending the current partition
        // T.C: O(N) where N is the length of S
        // S.C: O(N)
        int[] last = new int[26];
        for(int i=0; i<S.length(); i++){
            last[S.charAt(i) - 'a'] = i; // ***
        }

        int start = 0; // start of the curr partition
        int end = 0; // end of the curr partition
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<S.length(); i++){ // *****
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end){
                res.add(i - start +1); // length of a partition
                start = i+1;
            }
        }
        return res;
    }
}
