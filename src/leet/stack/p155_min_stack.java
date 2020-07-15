package leet.stack;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.Stack;

/**
 * p155 - 最小栈
 * @author wgq
 * @date 2020/7/15 5:19 下午
 */
public class p155_min_stack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> helperStack = new Stack<>();


    public void push(int x) {
        stack.push(x);
        if (helperStack.isEmpty() || helperStack.peek() > x) {
            helperStack.push(x);
        } else {
            helperStack.push(helperStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            helperStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helperStack.peek();
    }

    public static void main(String[] args) {
        p155_min_stack solution = new p155_min_stack();

        solution.push(0);
        solution.push(1);
        solution.push(0);
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.top());
        System.out.println(solution.getMin());
    }
}
