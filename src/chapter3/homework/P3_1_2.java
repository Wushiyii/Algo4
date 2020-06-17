package chapter3.homework;

import chapter3.AbstractSymbolTable;

/**
 * 无序数组实现符号表
 * @author wgq
 * @date 2020/6/17 11:49 上午
 */
public class P3_1_2<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] vals;
    private int n;

    public P3_1_2(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.vals = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {

        // to deal with duplicates
        delete(key);

        // double size of arrays if necessary
        if (n >= vals.length) resize(2*n);

        //add new key value
        keys[n] = key;
        vals[n] = value;
        n++;
    }

    @Override
    public Value get(Key key) {

        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                // 左移
                keys[i] = keys[n-1];
                vals[i] = vals[n-1];
                keys[n-1] = null;
                vals[n-1] = null;
                n--;
                if (n > 0 && n == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }

    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n ; i++)
            tempk[i] = keys[i];
        for (int i = 0; i < n; i++)
            tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }
}
