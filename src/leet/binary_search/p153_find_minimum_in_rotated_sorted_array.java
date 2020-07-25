package leet.binary_search;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author wgq
 * @date 2020/7/24 6:09 下午
 */
public class p153_find_minimum_in_rotated_sorted_array {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // right = mid的原因是需要考虑 mid为端点
                right = mid;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        p153_find_minimum_in_rotated_sorted_array solution = new p153_find_minimum_in_rotated_sorted_array();
        int[] nums = {3,4,5,1,2};
        System.out.println(solution.findMin(nums));
    }

}
