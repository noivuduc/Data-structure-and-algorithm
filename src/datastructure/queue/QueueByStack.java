package datastructure.queue;

import java.util.Stack;

public class QueueByStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        QueueByStack queue = new QueueByStack();
        queue.enQueue(1);
        queue.enQueue(3);
        queue.enQueue(5);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }

    /**
     * - While stack1 is not empty, move everything from stack1 to stack2
     * - Push number into stack1
     * - Move everything from stack2 back to stack1
     * - Time complexity is O(n)
     * @param number number need to push
     */
    public void enQueue(int number) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(number);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /**
     * - If stack1 is empty => throw error
     * - Get from stack1
     * @return Integer
     */
    public int deQueue() {
        if (stack1.isEmpty()) {
            throw new Error("Queue is empty!!!");
        }
        return stack1.pop();
    }
}
