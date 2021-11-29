package com.datastructures.impl;

import com.datastructures.helper.Node;

public class LinkedListImpl {

    private Node head;

    private int size;

    public void add(Object dataValue) {
        Node node = new Node(dataValue);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            head = node;
            head.setNextNode(temp);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object get(int index) {
        if (index < 0) {
            return null;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            if (currentNode.getNextNode() == null)
                return null;
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

    public boolean remove(int index) {
        Node previousNodeOfIndex = head;

        if (index < 0 || index > size - 1)
            return false;

        for (int i = 0; i < index - 1; i++) {
            if (previousNodeOfIndex.getNextNode() == null)
                return false;

            previousNodeOfIndex = previousNodeOfIndex.getNextNode();
        }
        Node nodeAtIndex = previousNodeOfIndex.getNextNode();
        Node nextNodeAfterIndex = nodeAtIndex.getNextNode();
        previousNodeOfIndex.setNextNode(nextNodeAfterIndex);
        nodeAtIndex = null;
        size--;
        return true;
    }
}
