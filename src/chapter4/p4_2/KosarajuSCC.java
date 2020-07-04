package chapter4.p4_2;

/**
 * @author wgq
 * @date 2020/7/4 3:18 下午
 */
public class KosarajuSCC extends StrongCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DirectedDFSOrder order = new DirectedDFSOrder(G);
        for (Integer s : order.postReverse()) {
            if (!marked[s]) {
                dfs(G, s);
                count ++;
            }
        }
    }

    private void dfs(Digraph G, Integer v) {
        marked[v] = true;
        id[v] = count;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }


    @Override
    boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    int count() {
        return count;
    }

    @Override
    int id(int v) {
        return id[v];
    }
}
