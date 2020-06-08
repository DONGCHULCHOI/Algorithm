package leetcode;

public class Fibonacci {
    public int fibonacci(int n){ // fibonacci 0(0), 1(1), 1(2), 2(3), 3(4), 5(5) where the bracket means n th Fibonacci number
        // T.C: O(2^N) where N is the input n but n is also the depth/height of the recursion tree
        // S.C: O(N) where N is the input n but n is also the depth/height of the recursion tree
        if(n==0 || n==1)    return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public int fibonacciTopDown(int n){
        // T.C: O(N) where N is the input n but n is also the depth/height of the recursion tree
        // S.C: O(N) where N is the input n but n is also the depth/height of the recursion tree
        return fibonacciTopDownHelper(n, new int[n+1]); // because fibonacci starts with 0 th
    }
    public int fibonacciTopDownHelper(int i, int[] memo){
        if(i==0 || i==1)    return i;

        if(memo[i] == 0){
            memo[i] = fibonacci(i-1) + fibonacci(i-2);
        }
        return memo[i]; // when finally get the result of nth, we need the array of the length n+1
    }

    public int fibonacciBottomUp(int n){
        // T.C: O(N) where N is the input n
        // S.C: O(N)
        if(n==0 || n==1)    return n;

        int[] memo = new int[n]; // we compute the results right before the n th, i.e. compute till n-1 th // also fibonacci starts with 0 th
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i<n; i++){ // compute till n-1 th
            memo[i] = memo[i-2] + memo[i-1];
        }
        return memo[n-1] + memo[n-2]; // when finally get the result of nth, we just need the array of the length n
    }

    public int fibonacciBottomUpImproved(int n){
        // T.C: O(N) where N is the input n
        // S.C: O(1)
        if(n==0)    return 0;
        int a=0;
        int b=1;
        for(int i=2; i<n; i++){
            int c = a + b; // memo[i](c) = memo[i-2](a) + memo[i-1](b)
            a = b; // update a
            b = c; // update b
        }
        return a+b;
    }
    
}

