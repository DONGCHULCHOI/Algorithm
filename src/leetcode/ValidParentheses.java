package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        // T.C: O(n)
        // S.C: O(n)
        // A parenthesis expression is valid then, a sub-expression of the valid expression should also be a valid expression
        // The stack data structure can come in handy here in representing this recursive structure of the problem
        // when opening bracket, push on to the stack
        // when closing bracket, pop from the stack, and compare the top with the opening bracket of the closing bracket
        // finally, check whether the size of stack is 0 or not, if not, then it means there is un-matched pairs in the string
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        Stack<Character> stack = new Stack<>(); // ***

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){ // when closing bracket // *****
                char top = (stack.size() == 0) ? '#' : stack.pop(); // ***
                if(top != map.get(c)){ // whether the element of the top is an opening bracket of the same type // *****
                    return false;
                }
            }
            else { // when opening bracket // *****
                stack.push(c);
            }
        }
        return stack.size() == 0 ? true : false ; // if stack still has elements, then invalid expression // *****
    }
}

