package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    // Backtracking:
    // Consider time complexity next time
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        if(digits.length() != 0){
            backtrack(list, new StringBuilder(), digits, map);
        }
        return list;
    }

    public void backtrack(List<String> list, StringBuilder assignment, String digits, Map<String, String> map){
        if (digits.length() == 0) {
            list.add(assignment.toString());
            return;
        }

        String domains = map.get(digits.substring(0, 1)); // e.g. 23; [a,b,c] for 2, [d,e,f] for 3 // *****
        for (int i = 0; i < domains.length(); i++) {
            assignment.append(domains.substring(i, i + 1));
            backtrack(list, assignment, digits.substring(1, digits.length()), map); // e.g. 23 -> 3
            assignment.deleteCharAt(assignment.length() - 1);
        }
    }
}
