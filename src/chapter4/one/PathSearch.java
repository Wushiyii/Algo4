package chapter4.one;

/**
 * @author wgq
 * @date 2020/6/30 9:51 下午
 */
public interface PathSearch {

    /**
     * 是否存在从起点s到v的路径
     * @param v v顶点
     * @return 是否存在路径
     */
    boolean hasPathTo(int v);


    /**
     * 起点s到v的所有路径
     * @param v 顶点v
     * @return 所有路径，不存在则返回null
     */
    Iterable<Integer> pathTo(int v);

}
