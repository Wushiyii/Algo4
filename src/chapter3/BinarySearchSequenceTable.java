package chapter3;

public class BinarySearchSequenceTable<K extends Comparable<K>, V> extends AbstractSequenceTable<K, V> {

    private K[] keys;
    private V[] values;
    private int N;

    public BinarySearchSequenceTable(int capacity) {
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    @Override
    public void put(K key, V value) {
        int rank = rank(key);
        if (rank < N && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }
        // 已存在key，但是不匹配的，将rank后的元素全体右移一位
        for (int i = N; i > rank ; i--) {
            keys[i] = keys[i-1];
            values[i] = values[i-1];
        }
        keys[rank] = key;
        values[rank] = value;
        N++;
    }

    @Override
    public V get(K key) {
        if (isEmpty()) {
            return null;
        }
        int rank = rank(key);
        if (rank < N && keys[rank].compareTo(key) == 0) {
            return values[rank];
        } else {
            return null;
        }
    }

    public int rank(K key) {
        int low = 0, high = N -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = keys[mid].compareTo(key);
            if (compare < 0) {
                low = mid + 1;
            } else if (compare > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    @Override
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        ST<String, String> st = new BinarySearchSequenceTable<>(10);
        st.put("CCC", "11111");
        st.put("ZZZ", "22222");
        st.put("BBB", "33333");
        st.put("XXX", "44444");
        st.put("VVV", "55555");

        System.out.println(st.get("ZZZ"));
        System.out.println(st.get("BBB"));
    }
}
