package chapter3;

/**
 * Hash散列表 (拉链法)
 * @author wgq
 * @date 2020/6/20 2:10 下午
 */
public class SeparateChainingHashSymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private int N; //键值对总数
    private int M; //散列表大小
    private BinarySearchSequenceSymbolTable<Key, Value>[] st;

    public SeparateChainingHashSymbolTable() {
        this(997);
    }

    private SeparateChainingHashSymbolTable(int M) {
        this.M = M;
        st = new BinarySearchSequenceSymbolTable[M];
        for (int i = 0; i < M; i++) {
            st[i] = new BinarySearchSequenceSymbolTable();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }


    public static void main(String[] args) {
        SeparateChainingHashSymbolTable<String, String> st = new SeparateChainingHashSymbolTable<>(10);
        st.put("CCC", "11111");
        st.put("ZZZ", "22222");
        st.put("BBB", "33333");
        st.put("XXX", "44444");
        st.put("VVV", "55555");

        System.out.println(st.get("ZZZ"));
        System.out.println(st.get("BBB"));
    }
}
