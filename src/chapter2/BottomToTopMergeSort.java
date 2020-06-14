package chapter2;

import chapter2.rewrite1.ReWriteMergeSort;

public class BottomToTopMergeSort extends AbstractSort {

    private int[] aux;

    @Override
    public void sort(int[] arr) {
        int N =arr.length;
        aux = new int[N];

        for (int size = 1; size < N; size = size + size) {
            for (int low = 0; low < N - size; low = low + size + size) {
                merge(arr, low, low + size - 1, Math.min(low + size + size - 1, N -1));
            }
        }

    }


    private void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = arr[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > high) {
                arr[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,2,5,1,9,8,3,6,0,11,10,14,13,12};
        AbstractSort compareSort = new BottomToTopMergeSort();
        compareSort.check(arr);
    }

}
