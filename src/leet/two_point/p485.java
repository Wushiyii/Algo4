package leet.two_point;

/**
 * p485  -  最大连续1的个数
 * @author wgq
 * @date 2020/7/13 12:02 上午
 */
public class p485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, left = 0, right = 0, max = 0;
        while (right < n) {
            if (nums[right++] != 1) {
                max = Math.max(max, right - left - 1);
                left = right;
            }
        }
        return Math.max(max, right - left);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }


}
