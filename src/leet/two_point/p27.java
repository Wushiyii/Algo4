package leet.two_point;

/**
 * p27 - 移除元素
 * @author wgq
 * @date 2020/7/12 11:21 下午
 */
public class p27 {

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        final int res = removeElement(nums, val);
        System.out.println(res);
    }


}
