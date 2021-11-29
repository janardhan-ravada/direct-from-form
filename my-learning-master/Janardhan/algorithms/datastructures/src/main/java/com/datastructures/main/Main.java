package com.datastrutures.main;

import com.datastructures.impl.LinkedListImpl;

public class Main {

    public static void main(String args[]) throws Exception {

        LinkedListImpl singleLinkedList = new LinkedListImpl();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(7);
        singleLinkedList.add(6);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(8);
        singleLinkedList.add(9);
        singleLinkedList.add(11);

        System.out.println("size of linkedList" + singleLinkedList.size());

        for (int i = 0; i < singleLinkedList.size(); i++) {
            System.out.println(singleLinkedList.get(i));
        }

        System.out.println(singleLinkedList.remove(12));

        for (int i = 0; i < singleLinkedList.size(); i++) {
            System.out.println(singleLinkedList.get(i));
        }

        System.out.println(singleLinkedList.remove(2));

        for (int i = 0; i < singleLinkedList.size(); i++) {
            System.out.println(singleLinkedList.get(i));
        }
    }
}
