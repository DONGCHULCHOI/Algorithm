package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        // Greedy:
        // T.C: O(N) where N is the length of S
        // S.C: O(N) when all the chars are distinct
        // Find partitions where each letter appears in at most one as many as possible
        //  e.g. S = "ababcbacadefegde" -> it can be partitioned into ["ababcbacadefegde"] or ["ababcbaca", "defegde"]
        // Choose the smallest left-justified partition, then take greedy steps
        //      How to choose the smallest left-justified partition: // *****
        //      Consider the first label(char), say it's 'a'. The first partition must include it, and also the last occurrence of 'a'
        //      However, between those two occurrences of 'a', there could be other labels that make the minimum size of this partition bigger
        //      When each new label is encountered, process the last occurrence of that lable, extending the current partition

        // Find the index of the last occurence of the char(label) // *****
        int[] last = new int[26];
        for(int i=0; i < S.length(); i++) // <key,value> = <aphatbet, last idx>
            last[S.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i=0; i < S.length(); i++){
            end = Math.max(end, last[S.charAt(i)-'a']); // Extend the current partion when it meet new label // *****
            if(i == end){ // when choose left-justified partition, add res // *****
                res.add(i - start + 1); // the length of chars in the partition
                start = i + 1;
            }
        }
        return res;
    }
}
