package chapter4.p4_3;

/**
 * @author wgq
 * @date 2020/7/4 5:58 下午
 */
public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     *
     * @return 两个顶点之一
     */
    public int either() {
        return v;
    }

    /**
     *
     * @param vertex 顶点之一
     * @return 另一个顶点
     */
    public int other(int vertex) {
        if (vertex != v && vertex != w) {
            throw new RuntimeException("不一致的边，无法取到另一个顶点");
        }
        return vertex == v ? w : v;
    }

    public double weight() {
        return weight;
    }


    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight(), that.weight());
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
