package leetcode.amazon_google_questions;

public class DecodeString {
    // Consider T.C next time later
    private int pos = 0;
    public String decodeString(String s) {
        // T.C: O(N * S) where N is the length of String, and S is the max integer in front of the bracket
        // S.C: O(D) where recursive calls are placed on the stack, where D is the maximum level of nesting in the input
        // think of the input String is a nested character array by [],
        // different nest is at different depth
        // https://leetcode.com/problems/nested-list-weight-sum/solution/
        // https://leetcode.com/problems/decode-string/discuss/87615/Simple-Java-DFS-Solution
        StringBuilder sb = new StringBuilder();
        String num = "";
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            } else if (s.charAt(i) == '[') {
                pos = i + 1;
                String next = decodeString(s);
                for (int n = Integer.valueOf(num); n > 0; n--)
                    sb.append(next);
                num = "";
                i = pos;
            } else if (s.charAt(i) == ']') {
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}