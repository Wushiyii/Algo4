package chapter4;

import java.util.Stack;

/**
 * @author wgq
 * @date 2020/7/1 11:45 上午
 */
public class DepthFirstPathsSearch implements PathSearch {

    private boolean marked[];
    private int[] edgeTo;
    private final int s;


    public DepthFirstPathsSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }


    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(10);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);

        System.out.println(graph);

        int s = 0;

        DepthFirstPathsSearch pathsSearch = new DepthFirstPathsSearch(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (pathsSearch.hasPathTo(v)) {
                for (Integer x : pathsSearch.pathTo(v)) {
//                    if (x == s) {
//                        System.out.print(x);
//                    } else {
                        System.out.print("-" + x);
//                    }
                }
            }
            System.out.println();
        }
    }
}
