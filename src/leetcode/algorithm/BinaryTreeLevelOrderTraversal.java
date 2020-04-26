package leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /   \
 *    15    7
 *  /  \   / \
 *  4   5  8   9
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class BinaryTreeLevelOrderTraversal {
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(3);
        TreeNode rLeft = new TreeNode(9);
        TreeNode rRight = new TreeNode(20);
        TreeNode rrLeft = new TreeNode(15);
        TreeNode rrRight = new TreeNode(7);
        root.left = rLeft;
        root.right = rRight;
        rRight.left = rrLeft;
        rRight.right = rrRight;

        List<List<Integer>> result = levelOrder2(root);
        for (List<Integer> level : result) {
            System.out.println(level.toString());
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversalOrders = new ArrayList<>();
        int treeHeight = height(root);
        for (int level = 1; level <= treeHeight; level++) {
            List<Integer> elements = new ArrayList<>();
            getLevelElement(root, elements, level);
            traversalOrders.add(elements);
        }
        return traversalOrders;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            output.add(list);
        }
        return output;
    }

    public static void getLevelElement(TreeNode node,List<Integer> elements, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            elements.add(node.val);
        }

        if (level > 1) {
            getLevelElement(node.left, elements, level-1);
            getLevelElement(node.right, elements, level-1);
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (lheight > rheight) {
            return lheight + 1;
        }
        return rheight + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
