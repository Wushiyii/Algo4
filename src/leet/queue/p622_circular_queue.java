package leet.queue;

import java.util.Arrays;

/**
 * p622 - 设计循环队列
 * @author wgq
 * @date 2020/7/14 9:30 上午
 */
public class p622_circular_queue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public p622_circular_queue(int k) {
        this.data = new int[k];
        this.size = k;
        this.head = this.tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }

        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {

        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    @Override
    public String toString() {
        return "data : " + Arrays.toString(data) + "; head : " + head + "; tail : " + tail + "; size : " + size;
    }


    public static void main(String[] args) {
        p622_circular_queue obj = new p622_circular_queue(6);
        System.out.println(obj.enQueue(6));
        System.out.println(obj.Rear());
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(5));
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
        System.out.println(obj.Front());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());

    }

}
