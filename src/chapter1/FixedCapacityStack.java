package chapter1;

/**
 * 基于数组实现的固定容量栈
 * @author wgq
 * @date 2020/6/2 6:15 下午
 */
public class FixedCapacityStack<T> {

    private T[] a;

    private int n;

    public FixedCapacityStack(int capacity) {
        this.a =(T[]) new Object[capacity];
    }

    public void push(T item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[n++] = item;
    }

    public T pop() {
        T item = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) {
            resize(a.length/2);
        }
        return item;
    }

    public boolean isEmpty() { return n == 0; }

    public int size() {return n;}

    public void resize(int max) {
        T[] newArr = (T[]) new Object[max];
        for (int i = 0; i < n; i++) {
            newArr[i] = a[i];
        }
        a = newArr;
    }



    public static void main(String[] args) {
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(2);
        stack.push(1);
        stack.push(3);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
