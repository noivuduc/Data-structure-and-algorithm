package datastructure.queue;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.push(1);
        queue.push(2);
        queue.remove();
        queue.push(3);
        queue.remove();
        queue.push(4);
        queue.remove();
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.push(8);
        queue.push(9);
        queue.push(10);
        queue.print();
    }
}
