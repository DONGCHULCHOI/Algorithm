package leetcode.amazon_google_questions;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        // T.C: O(N) where N is the length of S
        // S.C: O(N) when all the chars are distinct
        // Greedy
        // repeatedly choose the smallest left-justified partition // *****
        //      How to: // *****
        //      Consider the first label(char), say it's 'a'. The first partition must include it, and also the last occurrence of 'a'
        //      However, between those two occurrences of 'a', there could be other labels that make the minimum size of this partition bigger
        //      When each new label is encountered, process the last occurrence of that lable, extending the current partition

        // 1st. Find the index of the last occurence of the char(label) // *****
        int[] last = new int[26];
        for(int i=0; i<S.length(); i++)
            last[S.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        int start = 0; // start of the curr partition
        int end = 0; // end of the curr partition
        for(int i=0; i<S.length(); i++){
            end = Math.max(end, last[S.charAt(i)-'a']); // 2nd. Extend the current partion when it meet new label // *****
            if(i == end){ // 3rd. when extension finishes, add res // *****
                res.add(i-start+1); // the num of chars in the partition
                start = i+1;
            }
        }
        return res;
    }
}
