package datastructure.Tree;

public class Tree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(TreeNode node, int value) {
        if (node == null || value == node.value) {
            return;
        }
        if (value < node.value) {
            if (node.left == null) {
                node.left = new TreeNode(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public void print() {
        if (root != null) {
            traverseInOrder(root);
        }
    }

    public void printRoot() {
        System.out.println(root);
    }

    public TreeNode get(int value) {
        if (root == null) {
            return null;
        }
        return get(root, value);
    }

    public void delete(int value) {
        delete(root, value);
    }

    private TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value >  node.value) {
            node.right = delete(node.right, value);
        } else if (value < node.value){
            node.left = delete(node.left, value);
        } else {
            // case 1 and 2
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // if node to delete has 2 children
            // find the replacement for the deleted node
            // if we take from left subtree, we have to find the max value of subtree
            // If we take from right subtree, we have to find the min value of the subtree
            node.value = min(node.right).value;
            node.right = delete(node.right, node.value);
        }
        return node;
    }

    public int min() {
        if (root != null) {
            return min(root).value;
        }
        throw new Error("Root is empty");
    }

    public int max() {
        if (root != null) {
            return max(root).value;
        }
        throw new Error("Root is empty");
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }
    private TreeNode max(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    private TreeNode get(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (value > node.value) {
            return get(node.right, value);
        }
        return get(node.left, value);
    }

    private void traverseInOrder(TreeNode node) {
        if (node.left != null) {
            traverseInOrder(node.left);
        }
        System.out.print(node.value + ", ");
        if (node.right != null) {
            traverseInOrder(node.right);
        }
    }
}
