package chapter4.two;

/**
 * @author wgq
 * @date 2020/7/2 5:29 下午
 */
public class DirectedDFS {

    private boolean[] marked;

    DirectedDFS(Digraph G, int s) {
        this.marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    DirectedDFS(Digraph G, Iterable<Integer> sources) {
        this.marked = new boolean[G.V()];
        for (Integer v : sources) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }


    boolean marked(int v) {
        return marked[v];
    }
}
