package leetcode.algorithm;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Solution https://medium.com/@punitkmr/best-time-to-buy-and-sell-stock-ii-7826845144eb
 */
public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,200};
        System.out.println(solution2(prices));
    }

    /**
     * Time complexity : O(n). Single pass.
     * Space complexity : O(1). Constant space required.
     */
    public static int peakValleySolution(int[] prices) {
        int profit = 0;
        int i = 0;
        while (i < prices.length-1) {
            // Find valley
            while (i < prices.length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            int valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1]) {
                i++;
            }
            int peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public static int solution2(int[] prices) {
        int diff = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                diff += prices[i]-prices[i-1];
            }
        }
        return diff;
    }
}
