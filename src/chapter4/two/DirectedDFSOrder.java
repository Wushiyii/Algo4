package chapter4.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 有向图中基于DFS的顶点排序
 * @author wgq
 * @date 2020/7/3 3:08 下午
 */
public class DirectedDFSOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> postReverse;


    DirectedDFSOrder(Digraph G) {

        marked = new boolean[G.V()];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        postReverse = new Stack<>();

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        // 前序队列在递归调用前将顶点加入队列
        pre.add(v);

        marked[v] = true;

        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        // 后序队列在递归调用后将顶点加入队列
        post.add(v);

        // 逆后续：在递归调用后将顶点压入栈
        postReverse.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> postReverse() {
        return postReverse;
    }


}
