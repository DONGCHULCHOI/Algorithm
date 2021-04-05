package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    // Brute force(backtracking):
    private List<String> res = new ArrayList<>();
    private Map<String, String> domains = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        domains.put("2", "abc");
        domains.put("3", "def");
        domains.put("4", "ghi");
        domains.put("5", "jkl");
        domains.put("6", "mno");
        domains.put("7", "pqrs");
        domains.put("8", "tuv");
        domains.put("9", "wxyz");

        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        backtracking(new StringBuilder(), digits);
        return res;
    }

    public void backtracking(StringBuilder assignment, String digits) {
        if(digits.length() == 0) {
            res.add(assignment.toString());
            return;
        }

        String domain = domains.get(digits.substring(0, 1));
        char[] tmp = domain.toCharArray();
        for(int i = 0; i < tmp.length; i++) {
            assignment.append(tmp[i]);
            backtracking(assignment, digits.substring(1));
            assignment.deleteCharAt(assignment.length() - 1);
        }

    }
}
