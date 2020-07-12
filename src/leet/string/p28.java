package leet.string;

/**
 * p28 - 实现 strStr()
 * @author wgq
 * @date 2020/7/12 9:35 下午
 */
public class p28 {

    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return 0;
        }

        int L = needle.length(), n = haystack.length();

        for (int i = 0; i < n - L + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.equals(haystack.substring(i, i + L))) {
                    return i;
                }
            }
        }
        return -1;
    }



}
