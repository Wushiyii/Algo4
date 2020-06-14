package chapter2;

public class HeapSort extends AbstractSort {
    @Override
    public void sort(int[] a) {
        int N = a.length;
        for (int k = N/2; k >= 0 ; k--) {
            sink(a, k, N);
        }

        for(int i = N-1; i >= 0; i--) { // 排序
            exchange(a, 0, i);
            sink(a, 0, i);
        }
    }

    private void sink(int[] arr, int i, int N) {
        while (2*i + 1< N) {
            int j = 2*i + 1;
            if (j < N - 1 && (arr[j] < arr[j+1])) {
                j++;
            }
            if (arr[i] > arr[j]) break;
            exchange(arr, i, j);
            i = j;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,2,5,1,9,8,3,6,0,11,10,14,13,12};
        AbstractSort sort = new HeapSort();
        sort.check(arr);
    }
}
