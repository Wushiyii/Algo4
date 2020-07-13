package leet.array;

import java.util.Arrays;

/**
 * @author wgq
 * @date 2020/7/13 6:04 下午
 */
public class p283 {

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[index++] = nums[j];
            }
        }
        for (;index < nums.length; index++) {
            nums[index] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,0,2,0,4,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
