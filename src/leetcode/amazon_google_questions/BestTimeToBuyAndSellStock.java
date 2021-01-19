package leetcode.amazon_google_questions;

public class BestTimeToBuyAndSellStock {
    public int maxProfitBottomUpOriginal(int[] prices) {
        // Keep the min price
        // Tip. draw the max profit so far array
        // T.C: O(N)
        // S.C: O(N)
        if(prices.length == 0) return 0;

        int[] memo = new int[prices.length];
        memo[0] = 0;
        int minPrice = prices[0];

        for(int i=1; i<prices.length; i++){
            memo[i] = Math.max(memo[i-1], prices[i]-minPrice);
            if(prices[i] < minPrice)    minPrice = prices[i];
        }
        return memo[prices.length-1];
    }
    public int maxProfit(int[] prices) {
        // T.C: O(N)
        // S.C: O(1)
        if(prices.length == 0) return 0;

        int a = 0;
        int minPrice = prices[0];

        for(int i=1; i<prices.length; i++){
            a = Math.max(a, prices[i]-minPrice);
            if(prices[i] < minPrice)    minPrice = prices[i];
        }
        return a;
    }
}

