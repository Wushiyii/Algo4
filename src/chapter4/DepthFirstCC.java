package chapter4;

/**
 * DFS实现连通分量判断
 * @author wgq
 * @date 2020/7/1 3:37 下午
 */
public class DepthFirstCC implements CC{

    private boolean marked[];
    private int[] id;
    private int count;

    public DepthFirstCC(Graph G) {
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }


    @Override
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(20);
        graph.addEdge(0, 6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 3);
        graph.addEdge(3, 4);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(11, 12);
        graph.addEdge(9, 12);

        System.out.println(graph);


        DepthFirstCC depthFirstCC = new DepthFirstCC(graph);
        System.out.println(depthFirstCC.connected(0, 1));
        System.out.println(depthFirstCC.connected(0, 7));
        System.out.println(depthFirstCC.connected(7, 8));
        System.out.println(depthFirstCC.connected(7, 9));
        System.out.println(depthFirstCC.connected(9, 10));
        System.out.println(depthFirstCC.connected(0, 9));
    }
}
