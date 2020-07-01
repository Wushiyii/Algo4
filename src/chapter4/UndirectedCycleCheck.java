package chapter4;

/**
 * 无向图是否有环检测
 * @author wgq
 * @date 2020/7/1 4:38 下午
 */
public class UndirectedCycleCheck {

    private boolean[] marked;
    private boolean hasCycle;

    public UndirectedCycleCheck(Graph G) {
        this.marked = new boolean[G.V()];
        //对每个顶点进行判断
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                System.out.println("dfs(G, " + s + ", " + s + ")");
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {

        marked[v] = true;
        System.out.println("marked[" + v + "] = true");
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                System.out.println("dfs(G, " + w + ", " + v + ")");
                dfs(G, w, v);
            } else {
                System.out.println("w=" + w + ", u=" + u + "; w != u :" + (w != u));
                if (w != u) {
                    hasCycle = true;
                    break;
                }
            }
        }

    }

    public boolean hasCycle() {
        return hasCycle;
    }


    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(3);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        UndirectedCycleCheck cycleCheck = new UndirectedCycleCheck(graph);
        System.out.println(cycleCheck.hasCycle());
    }

}
