package com.datastructures.helper;

public class Node {

    private Node nextNode;
    private Object data;

    public Node() {
        this.data = null;
        this.nextNode = null;
    }

    public Node(Object data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node(Object data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
