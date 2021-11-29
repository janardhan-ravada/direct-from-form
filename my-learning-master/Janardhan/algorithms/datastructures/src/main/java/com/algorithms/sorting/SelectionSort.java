package com.algorithms.sorting;

public class SelectionSort {

    public static void swap(Comparable[] inputArray, int index1, int index2) {
        Comparable temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }

    public static void selectionSort(Comparable[] inputArray) {
        int length = inputArray.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (inputArray[min].compareTo(inputArray[j]) > 0) {
                    min = j;
                }
            }
            swap(inputArray, i, min);
        }
    }

    public static void main(String args[]) {
        Integer[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        selectionSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
