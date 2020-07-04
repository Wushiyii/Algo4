package chapter4.p4_2;

import chapter1.Bag;

/**
 * @author wgq
 * @date 2020/7/2 5:07 下午
 */
public class DirectGraph extends Digraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;


    public DirectGraph(int V) {
        this.V = V;
        this.adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public Digraph reverseGraph() {

        Digraph reverseGraph = new DirectGraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer w : adj(v)) {
                reverseGraph.addEdge(w, v);
            }
        }

        return reverseGraph;
    }
}
