package leet.array;

/**
 * p724 - 寻找数组的中心索引
 * @author wgq
 * @date 2020/7/9 10:54 上午
 */
public class p724 {


    public int pivotIndex(int[] nums) {

        if (null == nums || nums.length < 3) {
            return -1;
        }

        int leftSum = 0, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (sum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}
