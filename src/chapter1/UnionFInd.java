package chapter1;

/**
 * @author wgq
 * @date 2020/6/10 8:47 下午
 */
public abstract class UnionFInd {

    protected int[] id; //分量ID
    protected int count; //分量数量

    /**
     * 以整数标识（0 到 N-1 ) 初始化 N个分量
     * @param N 分量
     */
    public UnionFInd(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * @return 连通分量的数量
     */
    public int count() {
        return this.count;
    }

    /**
     *
     * @param p 分量p
     * @param q 分量q
     * @return 如果 p 和 q 存在于问一个分量中则返回 tru e
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     *
     * @param p 分量p
     * @return P所在的分量的标识符（0 到 N - 1 )
     */
    public abstract int find(int p);

    /**
     * 在p分量与q分量之间添加链接
     * @param p p分量
     * @param q q分量
     */
    public abstract void union(int p, int q);

}
