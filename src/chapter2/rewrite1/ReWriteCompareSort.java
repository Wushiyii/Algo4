package chapter2.rewrite1;

import chapter2.AbstractSort;

public class ReWriteCompareSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exchange(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,2,5,1,9,8,3,6,0,11,10,14,13,12};
        AbstractSort compareSort = new ReWriteCompareSort();
        compareSort.check(arr);
    }
}
