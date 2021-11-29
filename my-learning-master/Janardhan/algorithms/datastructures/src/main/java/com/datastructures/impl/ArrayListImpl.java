package com.datastructures.impl;

import java.util.Arrays;

import com.datastructures.api.ArrayList;

public class ArrayListImpl<E> implements ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static Object[] arrayData;

    private int size;

    public ArrayListImpl() {
        arrayData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayListImpl(int internalSize) {
        if (internalSize < 0) {
            throw new IllegalArgumentException(
                    "Illegal capacity" + internalSize);
        }
        arrayData = new Object[internalSize];
    }

    public void add(E e) {
        checkCapacity();
        arrayData[size] = e;
        size++;
    }

    private void checkCapacity() {
        if (arrayData.length - (size + 1) <= 0) {
            increaseSize();
        }
    }

    private void increaseSize() {
        int oldCapacity = arrayData.length;
        int newCapacity = oldCapacity + oldCapacity / 2;
        Arrays.copyOf(arrayData, newCapacity);
    }

    public void add(int index, E e) {
        if (index > size)
            throw new IndexOutOfBoundsException("Index out of bounds");

        checkCapacity();

        System.arraycopy(arrayData, index, arrayData, index + 1, size - index);
        arrayData[index] = e;
        size++;
    }

    public Object remove(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds" + index);

        Object temp = arrayData[index];

        System.arraycopy(arrayData, index + 1, arrayData, index,
                size - index + 1);
        size--;
        return temp;
    }

    public boolean remove(Object o) {
        return false;
    }

    public int size() {
        return size;
    }

}
