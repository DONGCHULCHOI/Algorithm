package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        // T.C: O(QK) where Q is the length of words, and K is the maximum length of a word
        // S.C: O(K)
        // First do run length encoding which is getting the count of each charcter in string
        // let's say we have individual counts c1 = S.count[i] and c2 = word.count[i]
        // If c1 < c2, then we can't make the ith group of word equal to the ith word of S by adding characters
        // If c1 >= 3, then we can add letters to the ith group of word to match the ith group of S by extending
        // if c1 < 3, then we must have c2 == c1 for the ith groups of word and S to match
        RLE R1 = new RLE(S);
        int ans = 0;

        search: for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R1.key.equals(R2.key)) continue;
            for (int i = 0; i < R1.counts.size(); ++i) {
                int c1 = R1.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }

}

class RLE { // Run Length Encoding
    String key;
    List<Integer> counts;

    public RLE(String S) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] ca = S.toCharArray();
        int N = ca.length;
        int prev = -1;
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || ca[i] != ca[i+1]) {
                sb.append(ca[i]);
                counts.add(i - prev);
                prev = i;
            }
        }

        key = sb.toString();
    }
}