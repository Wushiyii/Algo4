package leet.array;

/**
 * p153 - 寻找旋转排序数组中的最小值
 * @author wgq
 * @date 2020/7/13 4:12 下午
 */
public class p153 {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,1,2,3};
        System.out.println(findMin(nums));
    }

}
