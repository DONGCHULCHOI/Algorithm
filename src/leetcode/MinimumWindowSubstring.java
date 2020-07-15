package leetcode;

public class MinimumWindowSubstring {
    // T.C: O(n)
    //      because the inner while loop (while(counter==0) is always from the "begin", and the "begin" never goes back.
    //      So the total running is roughly the first for loop time, plus the while loop and its inner while loop: O(n)+O(2n) = O(n)
    // S.C: O(Max(m, n)) where m is the size of charset, n is because of s.substring for return
    // Follow substring template
    // the valid window is when the window includes chars in t
    // Valid is counter = 0
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray())  map[c]++; // *****
        int counter = t.length(), begin = 0, end = 0, minLen = Integer.MAX_VALUE, minBegin = 0;

        while (end < s.length()) { // Find a valid window
            if (map[s.charAt(end)] > 0) counter--;
            map[s.charAt(end)]--;
            end++;

            while (counter == 0) { // Contract till the window becomes invalid
                if (end - begin < minLen) { // ***** // because find minimum substring
                    minLen = end - begin;
                    minBegin = begin;
                }
                if (map[s.charAt(begin)] == 0)  counter++;
                map[s.charAt(begin)]++;
                begin++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minBegin, minBegin + minLen);
    }
}
