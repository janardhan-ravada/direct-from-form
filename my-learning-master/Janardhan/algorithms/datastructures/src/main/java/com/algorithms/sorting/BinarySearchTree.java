package com.algorithms.sorting;

import com.datastructures.helper.BinaryNode;

public class BinarySearchTree {

    private static BinaryNode root = null;

    /**
     * Add a node to BST
     * 
     * @param node
     */
    public static void addNode(BinaryNode node) {
        if (root == null) {
            root = node;
        } else {
            addNode(root, node);
        }
    }

    /**
     * Delete the given node
     * 
     * @param node
     */
    public static void deleteNode(BinaryNode node) {
        if (node != null) {
            deleteNode(node.getLeftChild());
            node.setLeftChild(null);
            deleteNode(node.getRightChild());
            node.setRightChild(null);
            node.setData(null);
        }
    }

    /**
     * Delete entire tree
     */
    public static void deleteTree() {
        deleteNode(root);
        root = null;
    }

    /**
     * Height of a node
     * 
     * @param node
     * @return
     */
    private static int height(BinaryNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftSubTreeSize = height(node.getLeftChild());
            int rightSubTreeSize = height(node.getRightChild());
            if (leftSubTreeSize > rightSubTreeSize)
                return 1 + leftSubTreeSize;
            else
                return 1 + rightSubTreeSize;
        }
    }

    /**
     * Height of the BST
     * 
     * @return
     */
    public static int height() {
        return height(root);
    }

    /**
     * Total nodes in a BST
     * 
     * @return
     */
    public static int size() {
        return size(root);
    }

    /**
     * Number of children a node has
     * 
     * @param node
     * @return
     */
    private static int size(BinaryNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }
    }

    /**
     * Add a child node to parent node
     * 
     * @param parent
     * @param child
     */
    public static void addNode(BinaryNode parent, BinaryNode child) {

        if (parent.getData().compareTo(child.getData()) < 0) {
            if (parent.getRightChild() != null) {
                addNode(parent.getRightChild(), child);
            } else {
                parent.setRightChild(child);
            }
        } else if (parent.getData().compareTo(child.getData()) >= 0) {
            if (parent.getLeftChild() != null) {
                addNode(parent.getLeftChild(), child);
            } else {
                parent.setLeftChild(child);
            }
        }
    }

    /**
     * Traversal BST in in-order(LEFT-ROOT-RIGHT)
     * 
     * @param node
     */
    public static void inOrderTraversal(BinaryNode node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());
        System.out.print(node.getData() + " ");
        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    /**
     * Traversal the tree in pre-order(ROOT-LEFT-RIGHT)
     * 
     * @param node
     */
    public static void preOrderTraversal(BinaryNode node) {
        System.out.print(node.getData() + " ");
        if (node.getLeftChild() != null)
            preOrderTraversal(node.getLeftChild());
        if (node.getRightChild() != null)
            preOrderTraversal(node.getRightChild());
    }

    /**
     * Traversal the node in post-order(LEFT-RIGHT-ROOT)
     * 
     * @param node
     */
    public static void postOrderTraversal(BinaryNode node) {
        if (node.getLeftChild() != null)
            postOrderTraversal(node.getLeftChild());
        if (node.getRightChild() != null)
            postOrderTraversal(node.getRightChild());
        System.out.print(node.getData() + " ");
    }

    /**
     * Print all the nodes from root to leaves
     * 
     * @param args
     */
    public static void printPaths(BinaryNode node, Comparable[] paths,
            int counter) {
        if (node != null) {
            paths[counter] = node.getData();
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                for (int i = 0; i <= counter; i++) {
                    System.out.print(paths[i] + ",");
                }
                System.out.println();
            }

            if (node.getLeftChild() != null) {
                printPaths(node.getLeftChild(), paths, counter + 1);
            }
            if (node.getRightChild() != null) {
                printPaths(node.getRightChild(), paths, counter + 1);
            }
        }
    }

    public static BinaryNode search(BinaryNode root, Comparable key) {
        if (root == null || root.getData().compareTo(key) == 0) {
            return root;
        } else if (root.getData().compareTo(key) < 0) {
            return search(root.getRightChild(), key);
        } else
            return search(root.getLeftChild(), key);
    }

    public static void printPaths() {
        Comparable[] paths = new Comparable[height()];
        printPaths(root, paths, 0);
    }

    public static int leafNodeCount(BinaryNode node) {
        if (node == null)
            return 0;
        else if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 1;
        } else {
            int leftLeaveCount = leafNodeCount(node.getLeftChild());
            int rightLeaveCount = leafNodeCount(node.getRightChild());
            return leftLeaveCount + rightLeaveCount;
        }

    }

    public static void main(String args[]) {
        Integer[] input = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < input.length; i++) {
            BinaryNode node = new BinaryNode(input[i]);
            bst.addNode(node);
        }
        printPaths();

        System.out.println(leafNodeCount(bst.root));

    }

}
