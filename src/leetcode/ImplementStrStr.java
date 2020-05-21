package leetcode;

public class ImplementStrStr {
    // Consider Rabin Karp approach next time
    public int strStrSubstring(String haystack, String needle) {
        // Sliding window
        // Substring: Linear time slice
        // T.C: O((N-L)L) *1)
        // S.C: O(1)
        int L = needle.length(), N = haystack.length();

        if(L == 0){ // *2)
            return 0;
        }

        for(int start=0; start<N-L+1; start++){ // N-L+1 is like the type length of the array in for loop
            if(haystack.substring(start, start+L).equals(needle)){
                return start;
            }
        }
        return -1;
        // 1) because where N is a length of haystack and L is a length of needle. We compute a substring of length L in a loop, which is executed (N - L) times
        // 2) when needle is an empty string. This is consistent to C's strstr() and Java's indexOf()
    }

    public int strStr(String haystack, String needle) {
        // Sliding window
        // improved Substring
        // Two Pointers: Linear time slice
        // Not compares all substring with needle, only compare when the first character of the window matches with -
        // the first character of the needle
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
