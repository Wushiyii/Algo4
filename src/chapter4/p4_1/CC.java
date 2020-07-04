package chapter4.p4_1;

/**
 * 连通分量判断
 * @author wgq
 * @date 2020/7/1 4:23 下午
 */
public interface CC {


    /**
     * @param v v顶点
     * @param w w顶点
     * @return v 与 w 是否连通
     */
    boolean connected(int v, int w);

    /**
     * @return 连通分量数
     */
    int count();

    /**
     * @param v v顶点
     * @return v顶点所在连通分量的标识符（0 ～ count()-1 ）
     */
    int id(int v);

}
