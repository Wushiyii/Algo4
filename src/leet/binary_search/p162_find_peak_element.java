package leet.binary_search;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wgq
 * @date 2020/7/23 9:04 下午
 */
public class p162_find_peak_element {

    public int findPeakElement(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;

        // 由于需要判断 nums[mid] > nums[mid + 1]  所以left必须小于right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当前数字大于右边第一个的数字，说明顶峰是mid  或者mid往左（需要考虑mid，所以right不是mid-1）
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            // 当前数字小于等于右边数字，说明顶峰在右边（不用考虑mid）
            } else {
                left = mid + 1;
            }
        }
        // 此时left = right 即为峰顶
        return left;
    }

    public static void main(String[] args) {
        p162_find_peak_element solution = new p162_find_peak_element();
        int[] nums = {1,2,2,2,3,1};
        System.out.println(solution.findPeakElement(nums));
    }
}
