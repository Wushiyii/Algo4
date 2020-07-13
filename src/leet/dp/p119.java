package leet.dp;

import java.util.Arrays;
import java.util.List;

/**
 * p119 - 杨辉三角 II  (DP)
 * @author wgq
 * @date 2020/7/13 3:29 下午
 */
public class p119 {

    public static List<Integer> getRow(int rowIndex) {
        //设置dp数组，先全部填充为1
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        // 从第三行开始(rowIndex行索引是以0为基数)
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0 ; j--) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return Arrays.asList(dp);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

}
