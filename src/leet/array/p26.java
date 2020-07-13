package leet.array;

/**
 * p26 -  删除排序数组中的重复项
 * @author wgq
 * @date 2020/7/13 5:48 下午
 */
public class p26 {

    public static int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int i = 1, j = 1;

        int leftNum = nums[0];
        while (j < nums.length) {

            if (leftNum == nums[j]) {
                j++;
            } else {
                nums[i] = nums[j];
                leftNum = nums[j];
                j++;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
