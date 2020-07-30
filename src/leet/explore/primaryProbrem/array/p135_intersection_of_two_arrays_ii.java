package leet.explore.primaryProbrem.array;

import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class p135_intersection_of_two_arrays_ii {

    /**
     *
     * 此处的取交集，只是取元素交集，不需要顺序，否则就是KMP了
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int left = 0, right = 0, index = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] < nums2[right]) {
                left ++;
            } else if (nums1[left] == nums2[right]) {
                res[index++] = nums1[left];
                left ++;
                right ++;
            } else {
                right++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);

    }

    public static void main(String[] args) {
        p135_intersection_of_two_arrays_ii solution = new p135_intersection_of_two_arrays_ii();
        int[] nums1 = {1,2,4,6,8,9,10};
        int[] nums2 = {6,8,10};
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2)));
    }

}
