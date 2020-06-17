package chapter3;

/**
 * @author wgq
 * @date 2020/6/17 3:10 下午
 */
public class BST<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value>{

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

    public Value min() {
        return min(root).val;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
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
        ST<String, String> st = new BST<>();
        st.put("123", "456");
        st.put("123", "999");
        st.put("567", "789");

        System.out.println(st.get("123"));
        System.out.println(st.get("567"));
    }
}
