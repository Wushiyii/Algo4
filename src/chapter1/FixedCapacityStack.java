package chapter1;

/**
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
        a[n++] = item;
    }

    public T pop() {
        return a[--n];
    }

    public boolean isEmpty() { return n == 0; }

    public int size() {return n;}



    public static void main(String[] args) {
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(5);
        stack.push(1);
        stack.push(3);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
