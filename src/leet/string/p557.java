package leet.string;

/**
 * p557 - 反转字符串中的单词 III
 * @author wgq
 * @date 2020/7/13 3:44 下午
 */
public class p557 {

    public static String reverseWords(String s) {
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (j < s.length()) {
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            res.append(reverse(s.substring(i, j))).append(" ");

            while (j < s.length() && s.charAt(j) == ' ') {
                j++;
            }
            i = j;
        }
        return res.toString().trim();
    }

    private static String reverse(String subStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = subStr.length() - 1; i >= 0; i--) {
            sb.append(subStr.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "eat a apple";
        System.out.println(reverseWords(str));
    }

}
