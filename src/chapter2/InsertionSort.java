package chapter2;

/**
 * 插入排序实现
 * 平均复杂度（N^2/4） 最坏(N^2/2)  最好(N-1)
 */
public class InsertionSort extends AbstractSort {


    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j],arr[j-1])) {
                    exchange(arr, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,1,2,6,8,9,2,3};
        AbstractSort compareSort = new InsertionSort();
        compareSort.check(arr);
    }


}


