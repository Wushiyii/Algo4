package leet.dp;

import java.util.Arrays;

/**
 * 凑零钱问题
 * @author wgq
 * @date 2020/7/15 10:50 上午
 */
public class CoinChange {

    // coins 中是可选硬币面值，amount 是目标金额
    static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins, 1));
        System.out.println(coinChange(coins, 2));
        System.out.println(coinChange(coins, 3));
        System.out.println(coinChange(coins, 4));
        System.out.println(coinChange(coins, 10));
    }
}
