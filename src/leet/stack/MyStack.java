package leet.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgq
 * @date 2020/7/15 5:11 下午
 */
public class MyStack {

    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data.remove(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        for (int i = 0; i < 4; ++i) {
            if (!s.isEmpty()) {
                System.out.println(s.top());
            }
            System.out.println(s.pop());
        }
    }

}
