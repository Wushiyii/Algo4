package chapter2;

public class OrderedArrayMaxPQ {

    private int[] pq;
    private int n;

    public OrderedArrayMaxPQ(int capacity) {
        pq = new int[capacity];
        n = 0;
    }

    public boolean isEmpty() {return n == 0;}

    public int size(){return n;}

    public void insert(int a) {
        int i = n - 1;
        //判断元素是否大于a， 大于的都往右边挪一位
        while (i >=0 && less(a, pq[i])) {
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = a;
        n++;
    }

    public int delMax() {
        return pq[--n];
    }

    private boolean less(int v, int w) {
        return v - w < 0 ;
    }

    public static void main(String[] args) {
        OrderedArrayMaxPQ    pq = new OrderedArrayMaxPQ(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(4);
        pq.insert(6);
        pq.insert(8);
        while (!pq.isEmpty())
            System.out.println(pq.delMax());
    }
}
