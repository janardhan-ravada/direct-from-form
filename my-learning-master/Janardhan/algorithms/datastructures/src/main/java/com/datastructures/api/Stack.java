package com.datastructures.api;

import com.datastructtures.exception.StackEmptyException;
import com.datastructtures.exception.StackOverFlowException;

public interface Stack {

    void push(Object element) throws StackOverFlowException;

    Object pop() throws StackEmptyException;

    boolean isEmpty();

    boolean isFull();

    int size();

    Object top() throws StackEmptyException;

}
