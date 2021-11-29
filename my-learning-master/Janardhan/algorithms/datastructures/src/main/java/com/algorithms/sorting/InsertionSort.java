package com.algorithms.sorting;

public class InsertionSort {

    public static void swap(Comparable[] inputArray, int index1, int index2) {
        Comparable temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }

    public static void insertionSort(Comparable[] input) {
        int length = input.length;
        for (int i = 0; i < length; i++) {
            Comparable key = input[i];
            int j = i - 1;
            while (j >= 0 && (key.compareTo(input[j]) < 0)) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        Integer[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        insertionSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
