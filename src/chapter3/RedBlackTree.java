package chapter3;


public class RedBlackTree<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;


    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    //判断节点与父节点之间的连接是否为红色
    public boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    //左旋转  取将两键较大者作为根节点
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    //右旋转  取将两键较小者作为根节点
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node h, Key key, Value value) {
        // 插入操作，与父节点用红链接相连
        if (h == null) {
            return new Node(key, value, 1, RED);
        }
        //递归插入操作，与二叉搜索树插入操作一致
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.val = value;
        }

        //旋转操作

        //右节点为红链接、左节点非红链接
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }


    @Override
    public Value get(Key key) {
        return null;
    }




    public void inOrderPrint() {
        inOrderPrint(root);
    }

    private void inOrderPrint(Node node) {
        if (node == null) return;
        inOrderPrint(node.left);
        System.out.println(node.key);
        inOrderPrint(node.right);

    }


    public static void main(String[] args) {
        RedBlackTree<String, String> redBlackTree = new RedBlackTree<>();
        redBlackTree.put("S", "S");
        redBlackTree.put("E", "E");
        redBlackTree.put("A", "A");
        redBlackTree.put("R", "R");
        redBlackTree.put("C", "C");
        redBlackTree.put("H", "H");
        redBlackTree.put("X", "X");
        redBlackTree.put("M", "M");
        redBlackTree.put("P", "P");
        redBlackTree.put("L", "L");

        redBlackTree.inOrderPrint();
    }


}
