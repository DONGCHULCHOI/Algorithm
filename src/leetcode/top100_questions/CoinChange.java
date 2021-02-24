package leetcode.top100_questions;

import java.util.Arrays;

public class CoinChange {
    // DP:
    // T.C: O(amount * n)
    // S.C: O(amount)
    // opt(i) = fewest number of coins to make up amount i given coins coins[0], ..., coins[n-1] // ****
    //        = min(opt[i-coins[0]], ... , opt[i-coins[n-1]]) + 1 if coins[idx] <= i
    public int coinChange(int[] coins, int amount) {
        int[] opt = new int[amount + 1];
        Arrays.fill(opt, amount + 1); // the case when cannot make up the amount // max possible value of amount is amount; e.g. amount 100, coin 1 //*****
        opt[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    opt[i] = Math.min(opt[i], opt[i-coin] + 1); // *****
                }
            }
        }

        return opt[amount] > amount ? -1 : opt[amount]; // opt[amount] > amount is the case where cannot make up the amount // *****
    }
}
