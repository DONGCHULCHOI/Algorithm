package leetcode.top100_questions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // DP:
    // T.C: O(n^3) because of substring taking O(n)
    // S.C: O(n)
    // si,k denote the substring sisi+1 ... sk
    // idx: _pen -> s0s1s2s3
    // Segmentation of substring s1,k is possible if only the last word(si+1,k) is in the dictionary, then the remaining substring s1,i can be segmented
    // determine if s can be segmented into a space-separated sequence of one or more dictionary words -> s1,i also be one or more dictionary words
    // opt(k) = whether substring s1,k can be segmented using the words in the dictionary
    //        = 1 if the segmentation is possible
    //        = 0 otherwise
    //        = Max(opt(i)), 0 <= i < k and si+1,k is a word in the dictionary
    //        = 0 otherwise
    // Max(opt(i)) -> s1,i also be one or more dictionary words
    // idx: _pen -> s0s1s2s3
    // idx of String in Java: pen -> s0s1s2
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();
        for(String word : wordDict) {
            dictionary.add(word);
        }

        boolean[] opt = new boolean[s.length() + 1];
        opt[0] = true;

        for(int k = 1; k < opt.length; k++) {
            for(int i = 0; i < k; i++) {
                if(opt[i] && dictionary.contains(s.substring(i,k))) { // because idx in here is +1 greater than idx of String
                    opt[k] = true;
                    break; // if you do not break, then ruins result like pen(O)p(X)en
                }
                else {
                    opt[k] = false;
                }
            }
        }

        return opt[s.length()];
    }
}
