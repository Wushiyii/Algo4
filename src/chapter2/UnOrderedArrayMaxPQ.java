package chapter2;

/**
 * 基于数组的无序优先最大队列
 */
public class UnOrderedArrayMaxPQ {

    private int[] pq;
    private int n;

    public UnOrderedArrayMaxPQ(int capacity) {
        pq = new int[capacity];
        n = 0;
    }

    public boolean isEmpty() {return n == 0;}

    public int size(){return n;}

    public void insert(int a) {
        pq[n++] = a;
    }

    public int delMax() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (pq[max] < pq[i]) {
                max = i;
            }
        }
        int temp = pq[max];
        pq[max] = pq[n-1];
        pq[n-1] = temp;

        return pq[--n];
    }

    public static void main(String[] args) {
        UnOrderedArrayMaxPQ pq = new UnOrderedArrayMaxPQ(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(4);
        pq.insert(6);
        pq.insert(8);
        while (!pq.isEmpty())
            System.out.println(pq.delMax());
    }
}
