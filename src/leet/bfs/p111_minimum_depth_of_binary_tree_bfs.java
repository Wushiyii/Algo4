package leet.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * p111 - 二叉树的最小深度 (BFS求解，也可用递归)
 * @author wgq
 * @date 2020/7/15 3:54 下午
 */
public class p111_minimum_depth_of_binary_tree_bfs {

    public int minDepth(TreeNode root) {

        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.add(root);

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur.left == null && cur.right == null) {
                    return depth;
                } else {
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }

            }
            depth++;
        }
        return depth;

    }

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        p111_minimum_depth_of_binary_tree_bfs solution = new p111_minimum_depth_of_binary_tree_bfs();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(20);

        System.out.println(solution.minDepth(root));

    }
}
