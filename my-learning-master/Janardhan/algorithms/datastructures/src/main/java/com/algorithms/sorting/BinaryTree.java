package com.algorithms.sorting;

import com.datastructures.helper.BinaryNode;
import com.sun.javafx.runtime.SystemProperties;

public class BinaryTree {

    public static void addNode(BinaryNode parent, BinaryNode child) {

        if (parent.getData().compareTo(child.getData()) < 0) {
            if (parent.getRightChild() != null) {
                addNode(parent.getRightChild(), child);
            } else {
                parent.setRightChild(child);
            }
        } else if (parent.getData().compareTo(child.getData()) > 0) {
            if (parent.getLeftChild() != null) {
                addNode(parent.getLeftChild(), child);
            } else {
                
                parent.setLeftChild(child);
            }
        }
    }

    public static void buildBinaryTree(Comparable[] input) {
        BinaryNode bTree = new BinaryNode();
        for (int i = 0; i < input.length; i++) {
            BinaryNode n = new BinaryNode(input[i]);

            /*BinaryNode parent = bTree.getParent();

            if (parent == null) {
                bTree.setParent(n);
            } else {
                addNode(parent, n);
            }*/
        }

        printNodes(bTree);
    }

    public static void printNodes(BinaryNode tree) {
        if (tree.getLeftChild() != null) {
            printNodes(tree.getLeftChild());
        }
        System.out.print(tree.getData());
        if (tree.getRightChild() != null) {
            printNodes(tree.getRightChild());
        }
    }

    public static void main(String args[]) {
        Integer[] input = { 5, 6, 2, 1, 3, 4, 9, 8, 10, 11, 99, 1, 2, 3 };
        buildBinaryTree(input);
    }
}
