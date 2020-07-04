package chapter4.p4_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wgq
 * @date 2020/7/1 2:28 下午
 */
public class BreadthFirstPathSearch implements PathSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    BreadthFirstPathSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            for (Integer w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
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

        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
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

        BreadthFirstPathSearch pathsSearch = new BreadthFirstPathSearch(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (pathsSearch.hasPathTo(v)) {
                Stack<Integer> path = (Stack<Integer>) pathsSearch.pathTo(v);
                while (!path.isEmpty()) {
                    Integer x = path.pop();
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }
}
