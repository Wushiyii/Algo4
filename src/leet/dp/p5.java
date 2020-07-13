
package leet.dp;


/**
 * p5 - 最长回文子串
 * @author wgq
 * @date 2020/7/12 12:22 上午
 */
public class p5 {

    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp代表 s[i...j] 是否为回文子串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // abcdce
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                }
                else {
                    if ( j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdcdce"));
    }

}
