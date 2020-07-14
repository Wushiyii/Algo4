package leet.bfs;

import java.util.*;

/**
 * BSF模板
 * @author wgq
 * @date 2020/7/14 5:31 下午
 */
public class BfsTemplate {

    private int bfs(Node start, Node target) {

        //BFS核心数据结构
        Queue<Node> queue = new LinkedList<>();

        //记录已扫描节点
        Set<Node> visit = new HashSet<>();

        //按需求设置扫描步数
        int step = 0;

        queue.offer(start);
        visit.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur == target) {
                    return step;
                } else {
                    for (Node node : cur.adj()) {
                        if (!visit.contains(node)) {
                            queue.add(node);
                            visit.add(node);
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    class Node {

        // 返回邻接顶点
        public List<Node> adj() {
            return Collections.emptyList();
        }
    }

}
