package chapter2.rewrite1;

import chapter2.AbstractSort;

public class ReWriteShellSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N/3) {
            h = 3 * h + 1;
        }
        while (h>=1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h ; j = j-h) {
                    if (less(arr[j], arr[j-h])) {
                        exchange(arr, j, j-h);
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,2,5,1,9,8,3,6,0,11,10,14,13,12};
        AbstractSort compareSort = new ReWriteShellSort();
        compareSort.check(arr);
    }
}
