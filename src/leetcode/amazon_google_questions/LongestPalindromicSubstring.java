package leetcode.amazon_google_questions;

public class LongestPalindromicSubstring {
    // Solve next time again totally following the below solution
    public String longestPalindrome(String s) { // *****
        // https://leetcode.com/problems/longest-palindromic-substring/discuss/151144/Bottom-up-DP-Logical-Thinking
        // Intuitively, we list all the substrings(n^2), pick those palindromic, and get the longest one
        // e.g. "aba"
        //      {
        //          {a, ab, aba},
        //          {    b,  ba}
        //          {         a}
        //      }
        // state(s, e) is true: // *****
        // for s = e,
        // for s + 1 = e,  if str[s] == str[e]
        // for s + 2 <= e, if str[s] == str[e] && state(s + 1, e - 1) is true
        // check the statement following the order, diagonal direction from bottom to up // *****
        // e.g. "aba"
        //      {
        //              2nd 3rd
        //          {a, ab, aba},
        //          {    b,  ba} 1st
        //          {         a}
        //      }
        // (!) state(s + 1, e - 1) should be calculated before state(s, e) // *****
        // That is, s is decreasing during the bottop-up dp implementation, while the dist between s and e is increasing
        //      for (int s = len - 1; s >= 0; s--) {
        //          for (int dist = 1; dist < len - i; dist++) {
        // r.f. dist = j-i, length = j-i+1

        int len = s.length();
        if (len <= 1) return s; // Corner cases.

        int longestPalindromeStart = 0, longestPalindromeLength = 1; // to track the max palindrome

        boolean[][] state = new boolean[len][len]; // state[i][j] true if s[i, j] is palindrome.
        for (int i = 0; i < len; i++) { // Base cases
            state[i][i] = true; // dist = 0 // diagonal
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int dist = 1; dist < len - i; dist++) {
                int j = dist + i;
                state[i][j] = (dist == 1) ? s.charAt(i) == s.charAt(j) : (s.charAt(i) == s.charAt(j)) && state[i + 1][j - 1];
                if (state[i][j] && j - i + 1 > longestPalindromeLength) {
                    longestPalindromeLength = j - i + 1;
                    longestPalindromeStart = i;
                }
            }
        }
        return s.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength);
    }
}