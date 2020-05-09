package datastructure.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Stack {
    private int[] stack;
    private int top;

    public Stack(int capacity) {
        stack = new int[capacity];
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            int[] newArray = new int[stack.length * 2];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = value;
    }

    public int pop() {
        if (size() < 0) {
            throw new NoSuchElementException();
        }
        int value = stack[top - 1];
        stack[top - 1] = 0;
        top--;
        return value;
    }

    public int size() {
        return top;
    }

    public void print() {
        System.out.println(Arrays.toString(stack));
    }
}
