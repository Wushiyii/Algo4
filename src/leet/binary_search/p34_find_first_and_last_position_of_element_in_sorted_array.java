package leet.binary_search;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wgq
 * @date 2020/7/24 7:28 下午
 */
public class p34_find_first_and_last_position_of_element_in_sorted_array {

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int left = 0, leftBound = -1, rightBound = -1, right = nums.length - 1;

        // 先找出左侧边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == nums.length || nums[left] != target ) {
            leftBound = -1;
        } else {
            leftBound = left;
        }

        //初始化
        left = 0;
        right = nums.length - 1;

        // 找出右侧边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            rightBound = -1;
        } else {
            rightBound = left - 1;
        }

        return new int[] {leftBound, rightBound};

    }



    public static void main(String[] args) {
        p34_find_first_and_last_position_of_element_in_sorted_array solution = new p34_find_first_and_last_position_of_element_in_sorted_array();

        int[] nums = {5};
        System.out.println(Arrays.toString(solution.searchRange(nums, 5)));

    }
}
