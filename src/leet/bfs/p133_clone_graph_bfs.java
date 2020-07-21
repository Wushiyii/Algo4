package leet.bfs;

import java.util.*;

/**
 * p133 - 克隆图 （BFS解法）
 * @author wgq
 * @date 2020/7/21 9:54 上午
 */
public class p133_clone_graph_bfs {

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


    public Node cloneGraph(Node node) {
        if (null == node) {
            return node;
        }
        // 老节点 - 克隆节点
        Map<Node, Node> visit = new HashMap<>();
        Node clone = new Node(node.val);
        visit.put(node, clone);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!visit.containsKey(neighbor)) {
                    // 往父节点的邻接节点key塞入克隆节点
                    visit.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                // 取到父节点的克隆节点， 把邻居节点的克隆节点放到邻接表里
                visit.get(cur).neighbors.add(visit.get(neighbor));
            }
        }
        return clone;
    }
}
