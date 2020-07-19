package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        // T.C: O(QK) where Q is the length of words, and K is the maximum length of a word
        // S.C: O(K)
        // extension operation: choose a group consisting of characters c,
        // and add some number of characters c to the group so that the size of the group is 3 or more
        // 1st. do RLE(Run Length Encoding) which is getting the count of each charcter in string
        // 2nd. let's say we have individual counts c1 = S.count[i] and c2 = word.count[i] where word is in words
        //      If c1 < c2, then we can't make the ith group of word equal to the ith word of S by adding characters
        //      If c1 >= 3, then we can add letters to the ith group of word to match the ith group of S by extending
        //          if c1 < 3, then we must have c2 == c1 for the ith groups of word and S to match
        RLE R1 = new RLE(S);
        int ans = 0;

        search: for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R1.key.equals(R2.key)) continue;
            for (int i = 0; i < R1.counts.size(); ++i) {
                int c1 = R1.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < c2 || c1 < 3 && c1 != c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }

}

class RLE { // Run Length Encoding
    String key; // key
    List<Integer> counts; // value

    public RLE(String s) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] c = s.toCharArray();
        int prev = -1; // *****

        for (int i = 0; i < c.length; i++) {
            if (i == c.length-1 || c[i] != c[i+1]) { // order *****
                sb.append(c[i]); // key
                counts.add(i - prev); // length
                prev = i;
            }
        }

        key = sb.toString();
    }
}