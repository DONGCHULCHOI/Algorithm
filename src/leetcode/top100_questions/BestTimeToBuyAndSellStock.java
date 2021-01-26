package leetcode.top100_questions;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // T.C: O(N)
        // S.C: O(1)
        // Find the biggest gap
        // Move a pointer from left to right
        // Update minPrice or update maxProfit
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }
}
