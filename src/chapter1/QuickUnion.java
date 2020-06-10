package chapter1;

/**
 * @author wgq
 * @date 2020/6/10 9:16 下午
 */
public class QuickUnion extends UnionFInd {

    /**
     * 以整数标识（0 到 N-1 ) 初始化 N个分量
     *
     * @param N 分量
     */
    public QuickUnion(int N) {
        super(N);
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

        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {

        QuickUnion union = new QuickUnion(10);

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
