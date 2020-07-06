package chapter4.p4_3;

import chapter2.IndexMinPQ;

/**
 * Prim算法 即时版本
 * @author wgq
 * @date 2020/7/6 10:29 上午
 */
public class PrimMST implements MST {

    private Edge[] edgeTo; // 距离生成树最近的边
    private double[] distTo; // distTo[w] = edgeTo[w].weight()
    private boolean[] marked; // 如果v在树中则为true
    private IndexMinPQ<Double> pq; // 有效横切边

    public PrimMST(EdgeWeightedGraph G) {
        this.edgeTo = new Edge[G.V()];
        this.distTo = new double[G.V()];

        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        this.marked = new boolean[G.V()];
        this.pq = new IndexMinPQ<>(G.V());

        // 初始化首节点数据
        distTo[0] = 0.0;
        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        // 将顶点v更新到最小生成树中，更新数据
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);

            if (marked[w]) {
                continue;
            }

            if (e.weight() < distTo[w]) {
                // 连接w和树的最佳边Edge变为e
                edgeTo[w] = e;
                distTo[w] = e.weight();

                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }


    @Override
    public Iterable<Edge> edges() {
        return null;
    }

    @Override
    public double weight() {
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(Double.POSITIVE_INFINITY);
    }
}
