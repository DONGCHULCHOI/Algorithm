package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    // Stack:
    // be careful considering the reversed order when using stack
    // time complexity later
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') { // decode string when meet ']'
                List<Character> decodedReversedString = new ArrayList<>();
                while(stack.peek() != '[') { // get encoded string
                    decodedReversedString.add(stack.pop());
                }

                stack.pop(); // pop [ from the stack
                int k = 0;
                int base = 1; // *****
                while(stack.size() != 0 && Character.isDigit(stack.peek())) { // get number
                    k = k + (stack.pop() - '0') * base; // *****
                    base *= 10;
                }

                while(k != 0) { // push decodedReversedString reversly into stack, repeat as many as number k
                    for(int j = decodedReversedString.size()-1; j >= 0; j--) {
                        stack.push(decodedReversedString.get(j));
                    }
                    k--;
                }
            }
            else { // push till meet ']'
                stack.push(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder(); // build result by reversing the decoded and reversed string in the stack
        while(stack.size() != 0) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
