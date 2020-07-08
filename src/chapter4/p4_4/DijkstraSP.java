package chapter4.p4_4;

import chapter2.IndexMinPQ;

import java.util.Arrays;
import java.util.Stack;

/**
 * 加权有向图最短路径(Dijkstra算法)
 * @author wgq
 * @date 2020/7/7 5:41 下午
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        this.edgeTo = new DirectedEdge[G.V()];

        this.distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[s] = 0.0;

        this.pq = new IndexMinPQ<>(G.V());
        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }



    /**
     * @param v v顶点
     * @return 从顶点s到顶点v的距离，如不存在则为无穷大
     */
    double distTo(int v) {
        return distTo[v];
    }

    /**
     * @param v v顶点
     * @return 是否存在s到v的路径
     */
    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * @param v 顶点v
     * @return 从顶点s到v的集合， 不存在为null
     */
    Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();

        for (DirectedEdge e = edgeTo[v]; e != null ; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    /**
     * 松弛边（如从s到v的距离+e的权重之和小于从s到w的距离， 则取小的值（最短路径））
     * @param e 边
     */
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }


    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();

            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }


    public static void main(String[] args) {

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(8);

        G.addEdge(new DirectedEdge(4, 5, 0.35));
        G.addEdge(new DirectedEdge(5, 4, 0.35));
        G.addEdge(new DirectedEdge(4, 7, 0.37));
        G.addEdge(new DirectedEdge(5, 7, 0.28));
        G.addEdge(new DirectedEdge(7, 5, 0.28));
        G.addEdge(new DirectedEdge(5, 1, 0.32));
        G.addEdge(new DirectedEdge(0, 4, 0.38));
        G.addEdge(new DirectedEdge(0, 2, 0.26));
        G.addEdge(new DirectedEdge(7, 3, 0.39));
        G.addEdge(new DirectedEdge(1, 3, 0.29));
        G.addEdge(new DirectedEdge(2, 7, 0.34));
        G.addEdge(new DirectedEdge(6, 2, 0.40));
        G.addEdge(new DirectedEdge(3, 6, 0.52));
        G.addEdge(new DirectedEdge(6, 0, 0.58));
        G.addEdge(new DirectedEdge(6, 4, 0.93));


        DijkstraSP sp = new DijkstraSP(G, 0);

        Stack<DirectedEdge> path = (Stack<DirectedEdge>) sp.pathTo(7);

        while (!path.isEmpty()) {
            System.out.println(path.pop());
        }
    }
}
