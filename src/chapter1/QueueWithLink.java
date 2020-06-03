package chapter1;

/**
 * 链表实现队列
 * @author wgq
 * @date 2020/6/3 4:38 下午
 */
public class QueueWithLink<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return oldFirst.item;
    }

    public static void main(String[] args) {
        QueueWithLink<Integer> queue = new QueueWithLink<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
