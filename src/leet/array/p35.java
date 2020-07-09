package leet.array;

/**
 * p35 - 搜索插入位置
 * @author wgq
 * @date 2020/7/9 1:09 下午
 */
public class p35 {

    public int searchInsert(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;

    }

}
