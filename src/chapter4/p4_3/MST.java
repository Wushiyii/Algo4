package chapter4.p4_3;

/**
 * 最小生成树（Minimum Spanning Tree）
 * @author wgq
 * @date 2020/7/4 8:01 下午
 */
public interface MST {

    /**
     *
     * @return 最小生成树的所有边
     */
    Iterable<Edge> edges();

    /**
     *
     * @return 最小生成树的权重
     */
    double weight();

}
