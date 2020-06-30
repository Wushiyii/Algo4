package chapter1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item>{

    //节点
    public class Node{
        private Item item;
        private Node next;
    }

    //背包中的元素个数
    private int nums;
    //背包起始位置
    private Node first;

    //初始化一个空的背包
    public Bag(){
        first = null;
        nums = 0;
    }

    //判断背包是否为空
    public boolean isEmpty(){
        return first == null;
    }

    //返回背包的元素个数
    public int size(){
        return nums;
    }

    //使用头插法添加元素
    public void add(Item item){
        //替换原始的第一个元素
        Node oldNode = first;
        //初始化一个新的元素
        first = new Node();
        //赋值
        first.item = item;
        first.next = oldNode;
        //背包个数加1
        nums++;
    }


    //迭代器可以遍历元素
    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        private Node now = first;

        @Override
        public boolean hasNext() {
            return now != null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = now.item;
            now = now.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);

        Iterator<Integer> iterator = bag.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}