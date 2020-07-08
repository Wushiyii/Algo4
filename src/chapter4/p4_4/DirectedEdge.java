package chapter4.p4_4;

/**
 * @author wgq
 * @date 2020/7/7 5:01 下午
 */
public class DirectedEdge {

    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    //指出这条边的顶点
    public int from() {
        return v;
    }

    //这条边指向的顶点
    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }



}
