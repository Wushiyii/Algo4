package chapter2;

/**
 * 选择排序实现
 * 复杂度 ： (N-1)+(N-2)+(N-3)+...+2+1 = N(N-1)/2 ~  N^2
 */
public class CompareSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {


        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exchange(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,1,2,6,8,9,2,3};
        AbstractSort compareSort = new CompareSort();
        compareSort.check(arr);
    }
}
