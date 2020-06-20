package chapter3;

/**
 * Hash散列表 (线性探测法)
 * @author wgq
 * @date 2020/6/20 3:42 下午
 */
public class LinearProbingHashSymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private int N;
    private int M;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashSymbolTable() {
        this(16);
    }

    private LinearProbingHashSymbolTable(int capacity) {
        this.M = capacity;
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }


    public void resize(int capacity) {
        LinearProbingHashSymbolTable<Key, Value> t = new LinearProbingHashSymbolTable<>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }


    @Override
    public void put(Key key, Value value) {
        if (N > M / 2) resize(M * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M ) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        // 未探测到已存在的key，则新增一个
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!keys[i].equals(key)) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;

        //往右的并且为线性插入的元素，进行左移
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }

        N--;
        if (N > 0 && N == M/8) resize(M / 2);
    }

    public static void main(String[] args) {
        LinearProbingHashSymbolTable<String, String> st = new LinearProbingHashSymbolTable<>(10);
        st.put("CCC", "11111");
        st.put("ZZZ", "22222");
        st.put("BBB", "33333");
        st.put("XXX", "44444");
        st.put("VVV", "55555");
        st.put("A", "1");
        st.put("S", "2");
        st.put("D", "3");
        st.put("Z", "4");
        st.put("X", "5");
        st.put("V", "6");

        System.out.println(st.get("ZZZ"));
        System.out.println(st.get("A"));
        System.out.println(st.get("X"));
        System.out.println(st.get("V"));

        st.delete("V");
        System.out.println("delete");
        System.out.println(st.get("V"));
    }
}
