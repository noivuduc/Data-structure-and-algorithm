package datastructure.heap;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int parent = getParent(index);
        int deletedValue = heap[index];
        // put the right most element of array to the deleted position
        heap[index] = heap[size - 1];
        heap[size - 1] = 0;
        // index = 0 means we're dealing with node
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size- 1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                   childToSwap = leftChild;
                } else {
                    childToSwap = Math.max(leftChild, rightChild);
                }

                if (heap[index] > heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int getChild(int index, boolean left) {
        return index * 2 + (left ? 1 : 2);
    }

    private boolean isFull() {
        return size == heap.length;
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }
}
