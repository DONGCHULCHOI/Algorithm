package leetcode.amazon_google_questions;

public class LicenseKeyFormatting {
    // T.C: O(n) where n is the length of the string
    // S.C: O(n)
    // using k is the most important concept
    // the dash mentioned in the question early can be ignored
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){ // *****
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i)); // *****
        }
        return sb.reverse().toString().toUpperCase();
    }
}