package chapter4.p4_2;

import java.util.Stack;

/**
 * DFS实现有向图路径搜索
 * @author wgq
 * @date 2020/7/4 3:34 下午
 */
public class DirectedDFSPathsSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s; // 起点

    DirectedDFSPathsSearch(Digraph G, int s){
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }


    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);

        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }



    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
