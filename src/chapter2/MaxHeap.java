package chapter2;

/**
 * 最大堆实现
 * 复杂度：插入：logN  删除：logN
 */
public class MaxHeap {
    private int[] pq;
    private int n = 0;

    public MaxHeap(int capacity) {
        pq = new int[capacity + 1];
    }

    public boolean isEmpty() {return n == 0;}

    public int size(){return n;}

    public void insert(int a) {
        pq[++n] = a;
        swim(n);
    }

    public int delMax() {
        int max = pq[1];
        exchange(1, n--);
        sink(1);
        return max;
    }

    private boolean less(int v, int w) {
        return pq[v] - pq[w] < 0 ;
    }

    private void exchange(int v, int w) {
        int temp = pq[v];
        pq[v] = pq[w];
        pq[w] = temp;
    }

    //上浮
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k/2, k);
            k = k / 2;
        }
    }

    //下沉
    private void sink(int k) {
        while (2*k < n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap  pq = new MaxHeap(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(4);
        pq.insert(6);
        pq.insert(8);
        while (!pq.isEmpty())
            System.out.println(pq.delMax());
    }
}
