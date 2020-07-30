package leet.explore.primaryProbrem.array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class p136_single_number {

    /**
     * 使用异或，每位数上输入相同时为0，不同则为1
     * 1101 ^ 0000 = 1101(13 ^ 0 = 13)
     * 1101 ^ 0010 = 1111(13 ^ 2 = 15)
     * 1101 ^ 0010 ^ 0010 = 1101(13 ^ 2 ^ 2 = 13)
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        p136_single_number solution = new p136_single_number();
        int[] nums = {4,1,2,1,2};
        System.out.println(solution.singleNumber(nums));
    }

}
