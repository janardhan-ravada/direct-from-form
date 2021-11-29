package com.datastructures.helper;

public class BinaryNode {

    private BinaryNode leftChild;
    private BinaryNode rightChild;
    private Comparable data;

    public BinaryNode() {
        this.data = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryNode(final Comparable data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

}
