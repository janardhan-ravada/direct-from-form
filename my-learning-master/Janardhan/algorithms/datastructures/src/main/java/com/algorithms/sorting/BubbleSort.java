package com.algorithms.sorting;

public class BubbleSort {

    public static void swap(Comparable[] inputArray, int index1, int index2) {
        Comparable temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }

    public static void bubbleSort(Comparable[] input) {
        int length = input.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (input[j].compareTo(input[j + 1]) > 0) {
                    swap(input, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] input = {10,9,8,7,6,5,4,3,2,1};
        bubbleSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

}
