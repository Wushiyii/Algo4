package chapter1;

/**
 * @author wgq
 * @date 2020/6/10 9:00 下午
 */
public class QuickUnionFind extends UnionFInd {

    /**
     * 以整数标识（0 到 N-1 ) 初始化 N个分量
     *
     * @param N 分量
     */
    public QuickUnionFind(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {

        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count --;
    }


    public static void main(String[] args) {

        QuickUnionFind union = new QuickUnionFind(10);

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
