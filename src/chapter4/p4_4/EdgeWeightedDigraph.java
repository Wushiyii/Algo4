package chapter4.p4_4;

import chapter1.Bag;

/**
 * 加权有向图
 * @author wgq
 * @date 2020/7/7 5:04 下午
 */
public class EdgeWeightedDigraph {

    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        this.adj[v].add(edge);
        this.E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge : this.adj(v)) {
                bag.add(edge);
            }
        }
        return bag;
    }



}
