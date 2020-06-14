package chapter2.rewrite1;

import chapter2.AbstractSort;

public class ReWriteInsertionSort extends AbstractSort {
    @Override
    public void sort(int[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 ; j--) {
                if (less(arr[j], arr[j-1])) {
                    exchange(arr, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,2,5,1,9,8,3,6,0,11,10,14,13,12};
        AbstractSort compareSort = new ReWriteInsertionSort();
        compareSort.check(arr);
    }
}
