package chapter4.p4_1;

/**
 * @author wgq
 * @date 2020/7/1 6:14 下午
 */
public class UndirectedTwoColorCheck {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public UndirectedTwoColorCheck(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (Integer w : G.adj(s)) {
            if (!marked[w]) {
                color[w] = !color[s];
                dfs(G, w);
            } else if (color[w] == color[s]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }


    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(3);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        UndirectedTwoColorCheck cycleCheck = new UndirectedTwoColorCheck(graph);
        System.out.println(cycleCheck.isTwoColorable());
    }
}
