package chapter3;

/**
 * 无序链表实现符号表
 * @author wgq
 * @date 2020/6/16 2:11 下午
 */
public class UnOrderedLinkTable<K extends Comparable<K>, V> extends AbstractTable<K, V> {

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
}
