package chapter1.homework;

import chapter1.QueueWithLink;
import chapter1.StackWithLink;

/**
 * 反转队列
 */
public class P1_3_6 {

    public static void reverseQueue(QueueWithLink<Integer> queue) {
        StackWithLink<Integer> stack = new StackWithLink<>();
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }

    public static void main(String[] args) {
        QueueWithLink<Integer> queue = new QueueWithLink<>();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);

        reverseQueue(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

}
