package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
        // Backtracking:
        // Consider time complexity next time
        private Map<String, String> phone = new HashMap<>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        private List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if(digits.length() != 0){
                backtrack("", digits);
            }
            return res;
        }

        public void backtrack(String assignment, String digits){
            if (digits.length() == 0) { // if complete
                res.add(assignment);
                return;
            }

            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(assignment + letter, digits.substring(1, digits.length()));
            }
        }
}
