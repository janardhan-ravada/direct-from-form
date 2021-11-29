package com.datastructures.api;

public interface ArrayList<E> {
    void add(E e);

    void add(int pos, E e);

    Object remove(int index);

    boolean remove(Object o);

    int size();
}
