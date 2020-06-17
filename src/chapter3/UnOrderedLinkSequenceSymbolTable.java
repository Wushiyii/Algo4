package chapter3;

/**
 * 无序链表实现符号表(顺序搜索)
 * @author wgq
 * @date 2020/6/16 2:11 下午
 */
public class UnOrderedLinkSequenceSymbolTable<K extends Comparable<K>, V> extends AbstractSymbolTable<K, V> {

    private Node first;

    @Override
    public void put(K key, V value) {
        for (Node x = first; x != null ; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
            }
        }
        first = new Node(key, value, first);
    }

    @Override
    public V get(K key) {
        for (Node x = first; x != null ; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ST<String, String> st = new UnOrderedLinkSequenceSymbolTable<>();
        st.put("123", "456");
        st.put("123", "999");
        st.put("567", "789");

        System.out.println(st.get("123"));
        System.out.println(st.get("567"));
    }
}
