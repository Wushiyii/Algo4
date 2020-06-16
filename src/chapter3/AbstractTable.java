package chapter3;

/**
 * 符号表实现
 * @author wgq
 * @date 2020/6/16 1:10 下午
 */
public abstract class AbstractTable<K extends Comparable<K>, V> implements ST<K, V> {

    @Override
    public abstract void put(K key, V value);

    @Override
    public abstract V get(K key);

    @Override
    public void delete(K key) {
        put(key, null);
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }
}
