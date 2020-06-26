package leetcode;

public class IsomorphicStrings {
    // T.C: O(N) where n is the length of s/t
    // S.C: O(1)
    // assume both s and t have the same length
    // The idea is that we need to map a char to another one, for example, "egg" and "add", we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'.
    // Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same
    // The reason why using 512 may be there are 256 characters in ASCII, 0-127 for basic ASCII, 128-255 for extended ASCII
    // m1, m2 are initialized as 0, to avoid putting 0 into the array (which is the initial value), just put i+1
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
