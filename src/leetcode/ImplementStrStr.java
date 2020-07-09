package leetcode;

public class ImplementStrStr {
    // Sliding Window (slice)
    // How to implement window slice is important // *****
    // Window slice means window, and the implementation of window slice means how to compare the window slice w/ the target
    // Valuable to review all three approaches

    public int strStr(String haystack, String needle) {
        // T.C: O(N) because O(L) for setup of rolling hash + O(N-L) for updating new rolling hash and comparison
        // S.C: O(1)
        // Rolling Hash // *****
        // Avoid overflow because of a^L by using long and % 2^31 // *****
        // Step 1. Compute the hash of substring haystack.substring(0, L) and reference hash of needle.substring(0, L)
        // Step 2. Iterate over the start position of possible match: from 1 to N - L
        //      Compute rolling hash based on the previous hash value
        //      Return start position if the hash is equal to the reference one
        //
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow // *****
        long modulus = (long)Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L] // *****
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) { // *****
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL + charToInt(start + L - 1, haystack)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }
    // function to convert character to integer
    public int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }

    public int strStrSubstring(String haystack, String needle) {
        // Approach 1: Substring: Linear Time Slice
        // T.C: O((N-L)L)
        // S.C: O(1)
        int L = needle.length(), N = haystack.length();

        if(L == 0){ // For the purpose of this problem, we will return 0 when needle is an empty string
            return 0;
        }

        for(int start=0; start<N-L+1; start++){
            if(haystack.substring(start, start+L).equals(needle)){
                return start;
            }
        }
        return -1;
    }

    public int strStrTwoPointers(String haystack, String needle) {
        // Approach 2: Two Pointers: Linear Time Slice
        // improved Approach 1
        // Not compares all substring with needle,
        // only compare when the first character of the window matches with the first character of the needle
        // T.C: O((N-L)L)
        // S.C: O(1)
        int L = needle.length(), N = haystack.length();

        if(L == 0){
            return 0;
        }

        int pN = 0; // prt for haystack
        while(pN < N-L+1){ // ***
            while(pN < N-L+1 && haystack.charAt(pN) != needle.charAt(0)){ // *****
                pN++;
            }
            int currLen = 0, pL = 0; // prt for needle
            while(pL < L && pN < N && haystack.charAt(pN) == needle.charAt(pL)){
                pN++;
                pL++;
                currLen++;
            }
            if(currLen == L){
                return pN - L; // ptr return to first start index
            }
            else{
                pN = pN - currLen + 1; // prt retrun to which is in front of the first start index
            }
        }
        return -1;
    }
}