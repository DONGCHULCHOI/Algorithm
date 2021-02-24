package leetcode.top100_questions;

public class CountingBits {
    // Bitwise:
    // T.C: O(nk)
    // S.C: O(n)
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            ans[i] = popCount(i);
        }
        return ans;
    }

    public int popCount(int x) {
        int count;
        for(count = 0; x != 0; count++) {
            x = x & x - 1; // zeroing out the least significant nonzero bit // *****
        }
        return count;
    }
}
