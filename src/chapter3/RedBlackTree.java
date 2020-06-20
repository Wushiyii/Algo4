package chapter3;

/**
 * 左倾红黑树 LLRB
 * @param <Key>
 * @param <Value>
 */
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

    // 假设节点为红色，且左节点与左节点的左节点为黑色。将左节点或者左节点的子节点改为红色
    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    // 假设结点h为红色 ，h.right 和 h.right.left 都是黑色，

    // 将 h.right 或者 h.right 的子结点之一变红
    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
        }
        return h;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
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

        //右节点为红链接、左节点非红链接 则左旋
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        //左节点为红、且左节点的左节点也为红，则右旋，并且在下一判断中进行颜色反转
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        //如果左节点与右节点皆为红色，则反转颜色
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }


    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return get(x.left, key);
        } else if (compare > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
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

    public boolean isBalanced() {
        int black = 0;
        Node x = root;
        while (x != null) {
            if (!isRed(x)) {
                black++;
            }
            x = x.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node x, int black) {
        if (x == null) {
            return black == 0;
        }
        if (!isRed(x)) {
            black--;
        }
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    }

    public boolean contains(Key key) {
        return get(key) != null;
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

        System.out.println(redBlackTree.isBalanced());

        System.out.println(redBlackTree.get("R"));
        System.out.println(redBlackTree.get("H"));
        System.out.println(redBlackTree.get("Z"));
    }


}
