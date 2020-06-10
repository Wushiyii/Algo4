package chapter1;

import java.util.Arrays;

/**
 * @author wgq
 * @date 2020/6/10 9:32 下午
 */
public class WeightQuickUnion extends UnionFInd {

    private int[] size;

    /**
     * 以整数标识（0 到 N-1 ) 初始化 N个分量
     *
     * @param N 分量
     */
    public WeightQuickUnion(int N) {
        super(N);
        size = new int[N];
        Arrays.fill(size, 1);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count --;
    }

    public static void main(String[] args) {

        WeightQuickUnion union = new WeightQuickUnion(10);

        union.union(4, 3);
        union.union(3, 8);
        union.union(6, 5);
        union.union(9, 4);
        union.union(2, 1);
        union.union(5, 0);
        union.union(7, 2);
        union.union(6, 1);
        union.union(1, 0);
        union.union(6, 7);

        System.out.println(union.count());
    }
}
