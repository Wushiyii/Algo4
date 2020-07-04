package chapter4.p4_2;

import java.util.Stack;

/**
 * @author wgq
 * @date 2020/7/2 8:06 下午
 */
public class DirectedCycle {

    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    DirectedCycle(Digraph G) {
        this.marked = new boolean[G.V()];
        this.onStack = new boolean[G.V()];
        this.edgeTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (Integer w : G.adj(v)) {
            if (hasCycle()) {return;}
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w ; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }


    boolean hasCycle() {
        return cycle != null;
    }

    Iterable<Integer> cycle() {
        return cycle;
    }


    public static void main(String[] args) {
        DirectGraph directGraph = new DirectGraph(10);
        directGraph.addEdge(0, 5);
        directGraph.addEdge(5, 4);
        directGraph.addEdge(4, 3);
        directGraph.addEdge(3, 5);

        System.out.println(directGraph);

        DirectedCycle directedCycle = new DirectedCycle(directGraph);

        System.out.println(directedCycle.hasCycle());

        Stack<Integer> cycle = directedCycle.cycle;

        StringBuilder path = new StringBuilder();
        while (!cycle.isEmpty()) {
            path.append(cycle.pop() + "-");
        }
        path.deleteCharAt(path.length() - 1);

        System.out.println(path);

    }

}
