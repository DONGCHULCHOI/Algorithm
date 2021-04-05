package leetcode.kakao;

import java.util.Stack;

public class 괄호변환 {    int pos;
    boolean isCorrect(String str) { // whether it is "올바른 괄호 문자열"
        boolean result = true;
        int left = 0, right = 0;
        Stack<Character> stack = new Stack<>();

        for(int i= 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                left++;
                stack.push('(');
            } else {
                right++;
                if(stack.isEmpty()) { // the pair does not match
                    result = false;
                } else { // the pair matches
                    stack.pop();
                }
            }
            if(left == right) {
                // find the shortest "균형 잡힌 괄호 문자열"
                // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며 -> u는 가장 짧아야
                pos = i + 1; // denote start pos of v and the length of the u
                return result;
            }
        }
        return true; // dummy // there is no case where we reach here because the input is alays "균형잡힌 괄호 문자열"
    }

    public String solution(String p) {
        // step 1
        if(p.length() == 0) {
            return p;
        }

        // step 2
        boolean correct = isCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());

        // step 3
        if(correct) {
            return u + solution(v); // define recursively
        }

        // step 4
        String answer = "(" + solution(v) + ")";
        for(int i = 1; i < u.length() - 1; i++) { // u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            if(u.charAt(i) == '(') {
                answer += ")";
            } else {
                answer += "(";
            }
        }

        return answer;
    }
}
