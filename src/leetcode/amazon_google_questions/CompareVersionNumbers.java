package leetcode.amazon_google_questions;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        // Two pointer
        // T.C: O(N+M+max(N,M)) where N and M are lengths of input strings
        // S.C: O(N+M) to store arrays nums1 and nums2
        // If one of the arrays is shorter, virtually add as many zeros as needed to continue to compare with the longer array // *****
        // assume the following:
        //  Version strings are composed of numeric strings separated by dots
        //  this numeric strings may have leading zeroes
        //  Version strings do not start or end with dots, and they will not be two consecutive dots
        // r.f. the 2nd sol is wrong
        String[] nums1 = version1.split("\\."); // T.C: O(M), S.C: O(M) // *****
        String[] nums2 = version2.split("\\."); // T.C: O(N), S.C: O(N) // *****
        int n1 = nums1.length, n2 = nums2.length;

        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); i++) { // T.C: O(max(M,N))// *****
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0; // parseInt removes leading zeros // T.C: O(1) because just one char // *****
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }
}
