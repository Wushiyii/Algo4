package chapter4.p4_1;

import chapter1.Bag;

/**
 * 无向图
 * @author wgq
 * @date 2020/6/30 4:14 下午
 */
public class UndirectedGraph extends Graph {

    private int V; // 顶点数
    private int E; // 边数
    private Bag<Integer>[] adj; // 邻接表

    @SuppressWarnings("unchecked")
    public UndirectedGraph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    @Override
    int V() {
        return V;
    }

    @Override
    int E() {
        return E;
    }

    @Override
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    Iterable<Integer> adj(int v) {
        return adj[v];
    }


}
