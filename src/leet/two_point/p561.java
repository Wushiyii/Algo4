package leet.two_point;

import java.util.Arrays;

/**
 * p561 - 数组拆分 I
 * @author wgq
 * @date 2020/7/12 10:45 下午
 */
public class p561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            res += nums[i];
        }
        return res;
    }

}
