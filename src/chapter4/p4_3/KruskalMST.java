package chapter4.p4_3;

import chapter1.QuickUnion;
import chapter1.UnionFInd;
import chapter2.MinPQ;

import java.util.*;

/**
 * @author wgq
 * @date 2020/7/7 11:21 上午
 */
public class KruskalMST implements MST {

    //最小生成树队列
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        this.mst = new LinkedList<>();

        // 优先队列获取每次入堆的最小边
        MinPQ<Edge> pq = new MinPQ<>(G.edges(), G.E());

        // 判断边两点是都否处于最小生成树中
        UnionFInd uf = new QuickUnion(G.V());

        // 判断是否生成的一个标志是 最小生成树的大小比G的顶点树小1
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);

            if (uf.connected(v, w)) {
                continue;
            }

            uf.union(v, w);
            mst.add(e);
        }
    }




    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return 0;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(16);

        graph.addEdge(new Edge(4, 5 , 0.35));
        graph.addEdge(new Edge(4, 7 , 0.37));
        graph.addEdge(new Edge(5, 7 , 0.28));
        graph.addEdge(new Edge(0, 7 , 0.16));
        graph.addEdge(new Edge(1, 5 , 0.32));
        graph.addEdge(new Edge(0, 4 , 0.38));
        graph.addEdge(new Edge(2, 3 , 0.17));
        graph.addEdge(new Edge(1, 7 , 0.19));
        graph.addEdge(new Edge(0, 2 , 0.26));
        graph.addEdge(new Edge(1, 2 , 0.36));
        graph.addEdge(new Edge(1, 3 , 0.29));
        graph.addEdge(new Edge(2, 7 , 0.34));
        graph.addEdge(new Edge(6, 2 , 0.40));
        graph.addEdge(new Edge(3, 6 , 0.52));
        graph.addEdge(new Edge(6, 0 , 0.58));
        graph.addEdge(new Edge(6, 4 , 0.93));


        KruskalMST kruskalMST = new KruskalMST(graph);
        System.out.println(kruskalMST.edges());

    }
}
