package chapter1;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int n, int[] arr) {
        if (null == arr || arr.length == 0){
            return -1;
        }
        int low = 0, high = arr.length -1;
        while (low <= high) {
            int mid = low + (low + high) / 2;
            if (arr[mid] < n) {
                high = mid - 1;
            } else if (arr[mid] > n) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,3,1,6,9,2};
        Arrays.sort(arr);
        System.out.println(binarySearch(5, arr));
    }

}
