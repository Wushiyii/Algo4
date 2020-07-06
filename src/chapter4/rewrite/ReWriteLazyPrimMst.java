package chapter4.rewrite;

import chapter2.MinPQ;
import chapter4.p4_2.DirectGraph;
import chapter4.p4_3.Edge;
import chapter4.p4_3.EdgeWeightedGraph;
import chapter4.p4_3.MST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wgq
 * @date 2020/7/4 9:51 下午
 */
public class ReWriteLazyPrimMst implements MST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public ReWriteLazyPrimMst(EdgeWeightedGraph G) {
        this.marked = new boolean[G.V()];
        this.mst = new LinkedList<>();
        this.pq = new MinPQ<>();

        visit(G, 0);

        while (!pq.isEmpty()) {
            Edge minEdge = pq.delMin();

            int v = minEdge.either(), w = minEdge.other(v);

            if (marked[v] && marked[w]) {
                continue;
            }

            mst.offer(minEdge);

            if (!marked[v]) {
                visit(G, v);
            }

            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
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


        ReWriteLazyPrimMst lazyPrimMST = new ReWriteLazyPrimMst(graph);
        System.out.println(lazyPrimMST.edges());

    }
}
