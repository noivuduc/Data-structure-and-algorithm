package datastructure.heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(20);
        heap.insert(10);
        heap.insert(25);
        heap.insert(30);
        heap.insert(13);
        heap.insert(19);
        heap.insert(22);
        heap.insert(81);
        heap.insert(99);
        heap.print();
        heap.delete(2);
        heap.print();
    }
}
