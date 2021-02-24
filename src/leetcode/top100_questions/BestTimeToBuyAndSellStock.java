package leetcode.top100_questions;

public class BestTimeToBuyAndSellStock {
    // Kadane's algorithm
    // T.C: O(N)
    // S.C: O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxSoFar = 0;

        for (int i = 0; i < prices.length; i++) { // Move ptr from left to right
            // calculate local(current) max profit at given ptr
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int currMax = prices[i] - minPrice; // currMax == 0 -> Buy, currMax != 0 -> sell, and following buy and sell rule

            maxSoFar = Math.max(maxSoFar, currMax); // update global max profit
        }

        return maxSoFar;
    }
}
