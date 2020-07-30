package leet.explore.primaryProbrem.linkedlist;

/**
 * @author wgq
 * @date 2020/7/30 5:45 下午
 */
public class p122_best_time_to_buy_and_sell_stock_ii {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max((prices[i] - prices[i-1]) + dp[i-1], dp[i-1]);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        p122_best_time_to_buy_and_sell_stock_ii solution = new p122_best_time_to_buy_and_sell_stock_ii();
        int[] prices = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {5,4,3,2,1};
        System.out.println(solution.maxProfit(prices3));
    }
}
