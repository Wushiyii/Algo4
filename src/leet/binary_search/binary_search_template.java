package leet.binary_search;

/**
 * @author wgq
 * @date 2020/7/21 2:02 下午
 */
public class binary_search_template {

    /**
     * 普通二分查找 其中left、right为左闭 右闭
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 寻找目标数最近的左侧边界
     */
    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

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
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 寻找目标数最近的右侧边界
     */
    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

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
            return -1;
        }

        return left;

    }



    public static void main(String[] args) {

        binary_search_template solution = new binary_search_template();
//
//        int[] nums2 = {Integer.MIN_VALUE,4,6,Integer.MAX_VALUE};
//        System.out.println(solution.binarySearch(nums2, 2));
//        System.out.println(solution.binarySearch(nums2, Integer.MAX_VALUE));
//        System.out.println(solution.binarySearch(nums2, 4));

//        int[] nums3 = {1,2,3,4,4,4,4};
//        System.out.println(solution.leftBound(nums3, 4));

        int[] nums4 = {1,2,3,4,4,4,4,5,6,7,9};
        System.out.println(solution.rightBound(nums4, 10));
    }


}
