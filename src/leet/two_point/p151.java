package leet.two_point;


/**
 * p151 - 翻转字符串里的单词
 * @author wgq
 * @date 2020/7/12 3:47 下午
 */
public class p151 {


    public String reverseWords(String s) {

        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i > -1) {

            // while循环向左搜索第一个空格
            while (i > -1 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s, i + 1, j + 1).append(" ");
            while (i > -1 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();

    }


}
