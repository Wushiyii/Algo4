package leet.dfs;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * leetcode提供的dfs模板
 * @author wgq
 * @date 2020/7/16 4:59 下午
 */
public class leetcode_template {

    boolean dfs(Node cur, Node target, Set<Node> visited) {
        if (target == cur) {
            return true;
        }

        for (Node node : cur.adj()) {
            if (!visited.contains(node)) {
                visited.add(node);
                dfs(node, target, visited);
            }
        }
        return false;
    }


    private class Node{
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        //泛指节点的邻接节点
        public List<Node> adj() {
            return Collections.EMPTY_LIST;
        }
    }

}
