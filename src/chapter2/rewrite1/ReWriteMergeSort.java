package chapter2.rewrite1;

import chapter2.AbstractSort;
import chapter2.MergeSort;

public class ReWriteMergeSort extends AbstractSort {

    private int[] aux;

    @Override
    public void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0 ,arr.length -1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid+1;

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
        AbstractSort compareSort = new ReWriteMergeSort();
        compareSort.check(arr);
    }

}
