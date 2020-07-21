package leet.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * p133 - 克隆图 （DFS解法）
 * @author wgq
 * @date 2020/7/21 9:54 上午
 */
public class p133_clone_graph_dfs {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node, Node> visit = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (null == node) {
            return node;
        }
        return dfs(node);

    }

    private Node dfs(Node node) {

        if (visit.containsKey(node)) {
            return visit.get(node);
        }

        Node clone = new Node(node.val);
        visit.put(node, clone);

        for (Node neighbor : node.neighbors) {
            Node cloneNeighbor = dfs(neighbor);
            clone.neighbors.add(cloneNeighbor);
        }
        return clone;
    }
}
