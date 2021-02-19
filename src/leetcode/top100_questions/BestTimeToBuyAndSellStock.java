package leetcode.top100_questions;

public class BestTimeToBuyAndSellStock {
    // Kadane's algorithm
    // T.C: O(N)
    // S.C: O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxSoFar = 0;

        // Move ptr from left to right
        for(int i = 0; i < prices.length; i++){
            // calculate local(current) max profit at given ptr
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int currMax = prices[i] - minPrice;

            // update global max profit
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
}
