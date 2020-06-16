package chapter3;

/**
 * 表API定义(简单起见，int作为key与value的类型)
 * @author wgq
 * @date 2020/6/16 1:03 下午
 */
public interface ST<K extends Comparable<K>, V> {

    void put(K key, V v);

    V get(K key);

    void delete(K key);

    boolean contains(K key);

    boolean isEmpty();

    int size();

    Iterable<K> keys();
}
