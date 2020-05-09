package datastructure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        back = 0;
    }

    public int size() {
        if (back >=front) {
            return back - front;
        }
        return back - front + queue.length;
    }

    public void push(int value) {
        if (size() == queue.length - 1) {
            int numItems = size();
            int[] newArray = new int[2 * queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;
            front = 0;
            back = numItems;
        }
        queue[back] = value;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public int remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        int value = queue[front];
        queue[front] = -1;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        if (front == queue.length - 1) {
            front = 0;
        }
        return value;
    }

    public int peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public void print() {
        System.out.println(Arrays.toString(queue));
    }

}
