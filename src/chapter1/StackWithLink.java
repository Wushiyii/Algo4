package chapter1;


/**
 * 链表实现栈
 * @author wgq
 * @date 2020/6/3 4:06 下午
 */
public class StackWithLink<Item> {

    private Node first;
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

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Node oldFirst = first;
        first = oldFirst.next;
        N--;
        return oldFirst.item;
    }


    public static void main(String[] args) {
        StackWithLink<Integer> stack = new StackWithLink<>();
        stack.push(1);
        stack.push(3);
        stack.push(6);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

    }
}
