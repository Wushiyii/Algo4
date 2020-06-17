package chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wgq
 * @date 2020/6/17 3:10 下午
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value>{

    // root node
    private Node root;


    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        //如果key存在node子树中，则更新值；否则将新节点插入子树中
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.val = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }


    private Value get(Node node, Key key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return get(node.left, key);
        } else if (compare > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }


    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null){
            return 0;
        } else {
            return node.N;
        }
    }

    public Node min() {
        return min(root);
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Node max() {
        return max(root);
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void delete(Key key) {
        delete(root, key);
    }

    //Hibbard 二叉树删除实现
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = delete(x.left, key);
        } else if (compare > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) { return x.left; }
            if (x.left == null) { return x.right; }
            //节点的两个子节点都不为空
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    public void inOrderPrint(Node node) {
        if (node == null) return;
        inOrderPrint(node.left);
        System.out.println(node.key);
        inOrderPrint(node.right);

    }

    public Iterable<Key> keys() {
        return keys(min().key, max().key);
    }


    private Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key low, Key high) {
        if (x == null) return;

        int comLow = low.compareTo(x.key);
        int comHigh = high.compareTo(x.key);

        if (comLow < 0) {
            keys(x.left, queue, low, high);
        }
        if (comLow <= 0 && comHigh >= 0) {
            queue.offer(x.key);
        }
        if (comHigh > 0) {
            keys(x.right, queue, low, high);
        }
    }

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value val,int n) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            N = n;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<String, String> st = new BinarySearchTree<>();
        st.put("789", "111");
        st.put("456", "222");
        st.put("567", "333");

        st.inOrderPrint(st.root);
        System.out.println(st.keys());
    }
}
