package chapter1.homework;

public class P1_3_14 {

    private static class ResizingArrayQueue<Item> {
        private Item[] arr;
        private int N;
        private int first;
        private int last;

        public ResizingArrayQueue(int size) {
            this.arr = (Item[]) new Object[size];
            first = last = 0;
        }

        public boolean isEmpty() {return N == 0;}

        public int size() {return N;}

        public void enqueue(Item item) {
            if (N == arr.length) {
                resize(arr.length * 2);
            }
            arr[last++] = item;
            if (last == arr.length) {
                last = 0;
            }
            N++;
        }

        public Item dequeue() {
            Item item = arr[first];
            arr[first] = null;
            first++;
            N--;
            if (first == arr.length) {
                first = 0;
            }
            if (N >0 && N == arr.length / 4) {
                resize(arr.length/2);
            }
            return item;
        }

        public void resize(int toBeSize) {
            Item[] temp = (Item[]) new Object[toBeSize];
            for (int i = 0; i < N; i++) {
                temp[i] = arr[(first + i) % arr.length];
            }
            arr = temp;
            first =0;
            last = N;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
