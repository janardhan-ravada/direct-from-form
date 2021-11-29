package com.datastructures.impl;

import com.datastructtures.exception.StackEmptyException;
import com.datastructtures.exception.StackOverFlowException;
import com.datastructures.api.Stack;

public class StackImpl implements Stack {

    public final int MAX_CAPACITY = 1024;
    private Object[] dataArray;

    private int topPosition;

    public StackImpl() {
        dataArray = new Object[MAX_CAPACITY];
        topPosition = -1;
    }

    public void push(Object element) throws StackOverFlowException {
        if (isFull())
            throw new StackOverFlowException();
        topPosition++;
        dataArray[topPosition] = element;
    }

    public Object pop() throws StackEmptyException {
        if (isEmpty())
            throw new StackEmptyException();
        Object removedElement = dataArray[topPosition];
        dataArray[topPosition] = null;
        topPosition--;
        return removedElement;
    }

    public boolean isEmpty() {
        return topPosition < 0;
    }

    public boolean isFull() {
        return (topPosition + 1) == MAX_CAPACITY;
    }

    public int size() {
        return topPosition + 1;
    }

    public Object top() throws StackEmptyException {
        if (isEmpty())
            throw new StackEmptyException();
        return dataArray[topPosition];
    }

}
