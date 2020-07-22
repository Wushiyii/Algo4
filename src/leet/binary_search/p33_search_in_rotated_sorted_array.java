package leet.binary_search;

/**
 * 33. 搜索旋转排序数组
 */
public class p33_search_in_rotated_sorted_array {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 中点比当前区间最左边大，说明[left. mid]为单调递增
            if (nums[mid] >= nums[left]) {
                // 如果target处于[left, mid)之间，缩小右区间查询即可
                if (target>= nums[left] && target< nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            //终点比当前区间最左边小，说明[mid, right]为单调递增
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        p33_search_in_rotated_sorted_array solution = new p33_search_in_rotated_sorted_array();
        int[] nums = {9,10,11,1,2,3,4,5,6,7};
        System.out.println(solution.search(nums, 7));
    }

}
