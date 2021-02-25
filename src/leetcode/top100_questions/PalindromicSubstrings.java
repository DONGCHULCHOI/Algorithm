package leetcode.top100_questions;

public class PalindromicSubstrings {
    // DP:
    // T.C: O(n^2)
    // S.C: O(n^2)
    // related problem: Palindromic Substrings, Longest Palindromic Substring
    // opt(i,j) = whether the substring si ... sj is palidrome
    //          = true if the substring si ... sj is palidrome
    //          = false otherwise
    //          = opt(i+1,j-1) if si == sj || si == si+1 // *****
    //          = false otherwise
    //         j
    //   ------------>
    // i |t         X
    //   |   t
    //   |      t           fill row by row from bottom to left, in the row, fill left to right
    //   |          t       do not use the idxes under diagonal
    //   V
    public int countSubstrings(String s) {
        int count = 0;

        int n = s.length();
        char[] charArr = s.toCharArray();
        boolean[][] opt = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            opt[i][i] = true;
            count++;
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if((charArr[i] == charArr[j] && opt[i+1][j-1]) || (i + 1 == j && charArr[i] == charArr[j])) {
                    opt[i][j] = true;

                    count++;
                }
            }
        }

        return count;
    }
}
