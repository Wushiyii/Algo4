package leet.dp;

import java.util.*;

/**
 * p279 - 完全平方数 BFS
 * @author wgq
 * @date 2020/7/14 6:07 下午
 */
public class p279_perfect_squares_dp {

    public int numSquares(int n) {

        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0 ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }


    public static void main(String[] args) {
        p279_perfect_squares_dp s = new p279_perfect_squares_dp();
//        System.out.println(s.numSquares(5));
        System.out.println(s.numSquares(12));
//        System.out.println(s.numSquares(13));
    }
}
