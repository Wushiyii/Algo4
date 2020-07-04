package chapter4.p4_2;

import java.util.Stack;

/**
 * 拓扑排序（当且仅当一幅有向图是无环图时它才能进行拓扑排序）
 * @author wgq
 * @date 2020/7/3 2:58 下午
 */
public class Topological {

    //顶点的拓扑排序
    private Iterable<Integer> order;
    private Iterable<Integer> pre;

    Topological(Digraph G) {
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()) {
            DirectedDFSOrder dfs = new DirectedDFSOrder(G);
            order = dfs.postReverse();
            pre = dfs.pre();
        }
    }


    /**
     * @return 是否是有向无环图
     */
    boolean isDAG() {
        return order != null;
    }

    /**
     * @return 拓扑排序的所有顶点
     */
    Iterable<Integer> order() {
        return order;
    }

    Iterable<Integer> pre() {
        return pre;
    }

    public static void main(String[] args) {
        DirectGraph directGraph = new DirectGraph(13);

        directGraph.addEdge(0, 6);
        directGraph.addEdge(0, 1);
        directGraph.addEdge(0, 5);

        directGraph.addEdge(5, 4);
        directGraph.addEdge(6, 4);
        directGraph.addEdge(6, 9);


        directGraph.addEdge(9, 12);
        directGraph.addEdge(9, 10);
        directGraph.addEdge(9, 11);

        directGraph.addEdge(11, 12);

        directGraph.addEdge(2, 3);
        directGraph.addEdge(2, 0);
        directGraph.addEdge(3, 5);

        directGraph.addEdge(8, 7);
        directGraph.addEdge(7, 6);

        System.out.println(directGraph);

        Topological topological = new Topological(directGraph);
        System.out.println("isDAG: " + topological.isDAG());


        Stack<Integer> order = (Stack<Integer>) topological.order;
        StringBuilder path = new StringBuilder();
        while (!order.isEmpty()) {
            path.append(order.pop()).append("-");
        }
        path.deleteCharAt(path.length() - 1);
        System.out.println("path : " + path);

        System.out.println("pre:" + topological.pre());

    }


}
