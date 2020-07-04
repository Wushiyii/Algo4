package chapter4.p4_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BFS实现有向图路径搜索
 * @author wgq
 * @date 2020/7/4 3:42 下午
 */
public class DirectedBFSPathsSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    DirectedBFSPathsSearch(Digraph G, int s) {

        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.distTo = new int[G.V()];
        // 初始化distTO 每个距离都为最大
        Arrays.fill(distTo, Integer.MAX_VALUE);

        validateVertex(s);
        bfs(G, s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;
        distTo[s] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.offer(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        Stack<Integer> path = new Stack<>();
        int x;
        for (x = v; distTo[x] != 0 ; x = edgeTo[x]) {
            path.push(x);
        }
        // 增加起点
        path.push(x);
        return path;
    }


    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
