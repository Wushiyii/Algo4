package chapter4.two;

/**
 * 强连通分量
 * @author wgq
 * @date 2020/7/4 2:51 下午
 */
public abstract class StrongCC {

    /**
     *
     * @param v v顶点
     * @param w w顶点
     * @return v与w是否是强连通的
     */
    abstract boolean stronglyConnected(int v, int w);

    /**
     *
     * @return 图中强连通分量的个数
     */
    abstract int count();

    /**
     *
     * @param v v顶点
     * @return v所在的强连通分量的标识符（0 ~ count()-1）
     */
    abstract int id(int v);

}
