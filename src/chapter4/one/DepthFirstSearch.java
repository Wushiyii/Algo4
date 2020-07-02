package chapter4.one;

/**
 * @author wgq
 * @date 2020/6/30 8:27 下午
 */
public class DepthFirstSearch implements GraphSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (Integer w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }


    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(10);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);
        graph.addEdge(1,4);

        System.out.println(graph);

        DepthFirstSearch search = new DepthFirstSearch(graph, 1);
        System.out.println(search.count());
    }

}
