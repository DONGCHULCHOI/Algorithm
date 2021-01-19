package leetcode.amazon_google_questions;

import java.util.Stack;

public class MinStack {
    // T.C: O(1) for all operations
    // S.C: O(n) where n is the number of operation, and all the operations are push, then the 2*n space is used including stack and also the value is a pair => n + n
    // push, pop, top, and retrieving the minimum element in constant time
    // Keep the min value like pair in the stack // *****
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) { // *****
        if(stack.size() == 0){
            stack.push(new int[]{x, x});
        }
        else{
            int currentMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, currentMin)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */