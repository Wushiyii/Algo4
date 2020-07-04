package chapter4.p4_3;

import chapter2.MinPQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Prim 算法实现加权无向图的最小生成树
 * @author wgq
 * @date 2020/7/4 8:11 下午
 */
public class LazyPrimMST implements MST{

    private boolean[] marked; //最小生成树的顶点
    private Queue<Edge> mst; //最小生成树的边
    private MinPQ<Edge> pq; //横切边（包括失效的边）

    LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new LinkedList<>();

        //从0开始，先标记与0连接，并且未被标记的顶点到pq中
        visit(G, 0);

        //再从其他顶点开始标记
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.offer(e);
            if (!marked[v]) {
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }


    private void visit(EdgeWeightedGraph G, int v) {
        //标记顶点v， 并将所有连接v和未被标记的顶点加入到pq中
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
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


        LazyPrimMST lazyPrimMST = new LazyPrimMST(graph);
        System.out.println(lazyPrimMST.edges());

    }
}
