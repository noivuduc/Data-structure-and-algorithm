package datastructure.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20);
        tree.insert(15);
        tree.insert(30);
        tree.insert(19);
        tree.insert(18);
        tree.insert(29);
        tree.insert(53);
        tree.insert(10);
        tree.insert(90);
        tree.print();
        System.out.println();
        tree.printRoot();
        tree.delete(15);
        tree.printRoot();
        System.out.println(tree.min());
        System.out.println(tree.max());
    }
}
