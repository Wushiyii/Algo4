package leet.two_point;

/**
 * p209 - 长度最小的子数组
 * @author wgq
 * @date 2020/7/13 11:30 上午
 */
public class p209 {

    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum = sum -  nums[i];
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
