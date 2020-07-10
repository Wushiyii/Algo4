package leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * p56 - 合并区间
 * @author wgq
 * @date 2020/7/9 5:31 下午
 */
public class p56 {


    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] interval = intervals[i];
            int[] last = res.get(res.size() - 1);

            if (interval[0] <= last[1]) {
                last[1] = Math.max(interval[1], last[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    public static void main(String[] args) {
        p56 solution = new p56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }


}
