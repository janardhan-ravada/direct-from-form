package com.algorithms.sorting;

public class HeapSort {

    public static void swap(Comparable[] inputArray, int index1, int index2) {
        Comparable temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }

    public static void heapSort(Comparable[] input) {
        int length = input.length - 1;
        for (int i = length; i >= 0; i--) {
            hepify(input, i);
            swap(input, 0, i);
        }
    }

    public static void hepify(Comparable[] input, int length) {
        for (int i = length / 2; i >= 0; i--) {
            maxHeapify(input, i, length);
        }
    }

    public static void maxHeapify(Comparable[] input, int index, int length) {
        int leftIndex = left(index);
        int rightIndex = right(index);
        int maxIndex = index;
        if (leftIndex <= length
                && (input[index].compareTo(input[leftIndex]) < 0)) {
            maxIndex = leftIndex;
        }

        if (rightIndex <= length
                && (input[maxIndex].compareTo(input[rightIndex]) < 0)) {
            maxIndex = rightIndex;
        }

        if (maxIndex != index) {
            swap(input, index, maxIndex);
            maxHeapify(input, maxIndex, length);
        }
    }

    private static int left(int index) {
        return 2 * index + 1;
    }

    private static int right(int index) {
        return 2 * index + 2;
    }

    public static void main(String args[]) {
        Integer[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 20 };
        heapSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

}
