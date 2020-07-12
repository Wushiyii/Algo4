package leet.two_point;

/**
 * p344 - 反转字符串
 * @author wgq
 * @date 2020/7/12 10:31 下午
 */
public class p344 {

    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
        System.out.println(s);
    }

}
