package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        // T.C: O(n)
        // S.C: O(n)
        // A parenthesis expression is valid then, a sub-expression of the valid expression should also be a valid expression
        // The stack data structure can come in handy here in representing this recursive structure of the problem
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        LinkedList<Character> stack = new LinkedList<>(); // ***

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){ // when closing bracket // ***
                char top = (stack.size() == 0) ? '#' : stack.pop();
                if(top != map.get(c)){ // whether the element of the top is an opening bracket of the same type // ***
                    return false;
                }
            }
            else { // when opening bracket // ***
                stack.push(c);
            }
        }
        return stack.size() == 0 ? true : false ; // if stack still has elements, then invalid expression // ***
    }
}
