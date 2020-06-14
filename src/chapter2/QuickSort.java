package chapter2;

public class QuickSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int j = partition(arr, low, high);
        sort(arr, low, j -1);
        sort(arr, j + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        //将数组切分为a[low... i-1], a[i], a[i+1...high]
        int i = low, j = high+1;
        int v = arr[i];

        while (true) {
            while (less(arr[++i], v)) {
                if (i == high) break;
            }
            while (less(v, arr[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, low, j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,2,5,1,9,8,3,6,0,11,10,14,13,12};
        AbstractSort compareSort = new QuickSort();
        compareSort.check(arr);
    }

}
