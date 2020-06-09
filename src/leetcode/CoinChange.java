package leetcode;

public class CoinChange {
    public int coinChangeRecursive(int[] coins, int amount) {
        // F(S)=min F(S-Ci) +1 where i = 0, 1, ..., n-1
        // T.C: O(n^S) where S is the amount, and n is the number of denominations
        // S.C: O(S) where S is the amount, and also the height of recursion tree
        if(amount < 1)  return 0;
        return coinChangeRecursiveHelper(coins, amount);
    }
    public int coinChangeRecursiveHelper(int[] coins, int rem){
        if(rem == 0)    return 0;
        if(rem < 0) return -1; // S-C < 0 // *****

        int min = Integer.MAX_VALUE; // *****
        for(int coin : coins){ // *****
            int res = coinChangeRecursiveHelper(coins, rem-coin);
            if(res < min && res >= 0) // *****
                min = res + 1;
        }
        return (min == Integer.MAX_VALUE) ? -1 : min; // *****
    }

    public int coinChange(int[] coins, int amount) {
        // Memoization
        // T.C: O(n*S) because tree's depth is S, and each node of those nodes has n-1 other childs, resulting in total n*s childs
        // S.C: O(S)
        if(amount < 1)  return 0;
        return coinChangeHelper(coins, amount, new int[amount+1]); // *****
    }
    public int coinChangeHelper(int[] coins, int rem, int[] memo){
        if(rem == 0)    return 0;
        if(rem < 0) return -1;

        if(memo[rem] == 0){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                int res = coinChangeHelper(coins, rem-coin, memo);
                if(res >= 0 && res < min)
                    min = res + 1;
            }
            memo[rem] = (min == Integer.MAX_VALUE) ? -1 : min; // *****
        }
        return memo[rem]; // *****
    }
}
