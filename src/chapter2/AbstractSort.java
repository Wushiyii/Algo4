package chapter2;

public abstract class AbstractSort {

    public abstract void sort(int[] arr);

    protected boolean less(int a, int b) {
        return a < b;
    }

    protected void exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    protected void show(int[] arr) {
        for (int comparable : arr) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    protected boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i-1])) {
                return false;
            }
        }
        return true;
    }

    protected void check(int[] arr) {
        sort(arr);
        show(arr);
        System.out.println(isSorted(arr));
    }

}
