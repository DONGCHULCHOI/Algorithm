package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    // Consider time complexity next time
    private Map<String, String> phone = new HashMap<>();
    private List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

        if(digits.length() != 0){
            backtrack("", digits);
        }
        return output;
    }

    public void backtrack(String curr, String digits){
        if (digits.length() == 0) { // ***** // base case & for the output
            output.add(curr);
            return;
        }

        String digit = digits.substring(0, 1); // ***
        String letters = phone.get(digit); // ***
        for (int i = 0; i < letters.length(); i++) { // ***** // (a)
            String letter = letters.substring(i, i + 1); // ***** // (b) => (a) together with (b) functions as "for"
            backtrack(curr + letter, digits.substring(1, digits.length())); // *****
        }
    }
}

