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


    public void resize(int toBeSize) {
        Key[] keyTemp = (Key[]) new Comparable[toBeSize];
        Value[] valueTemp = (Value[]) new Object[toBeSize];
        if (N >= 0) System.arraycopy(keys, 0, keyTemp, 0, N);
        keys = keyTemp;

        if (N >= 0) System.arraycopy(values, 0, valueTemp, 0, N);
        values = valueTemp;
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
    }
}
