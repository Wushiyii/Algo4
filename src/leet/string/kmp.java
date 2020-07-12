package leet.string;

/**
 * KMP 匹配算法
 * @author wgq
 * @date 2020/7/12 9:09 下午
 */
public class kmp {

    public static int match(String s, String p) {
        int[] next = buildNext(p); // 构造next表

        int m = s.length(), i = 0; //待匹配文本串指针
        int n = p.length(), j = 0; //模式串指针

        // 自左向右逐个进行对比
        while (j < n && i < m) {
            // 如果匹配， 则两指针都右移
            if (0 > j || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                // 不匹配，则模式串右移到模式串相同字符区域
                j = next[j];
            }
        }
        return i - j;
    }

    // 构造模式串p的next表
    private static int[] buildNext(String p) {
        int pLength = p.length(), j = 0; //主串指针
        int[] next = new int[pLength];

        //初始设置next数组第一个为-1
        int t = next[0] = -1;
        while (j < pLength - 1) {
            if (0 > t || p.charAt(j) == p.charAt(t)) {
                j++;
                t++;
                next[j] = t;
            } else {
                t = next[t];
            }
        }
        return next;


    }

    public static void main(String[] args) {
        String s = "ACTGPACTGKACTGPACY";
        String p = "ACTGPACY";
        System.out.println(match(s, p));
    }

}
