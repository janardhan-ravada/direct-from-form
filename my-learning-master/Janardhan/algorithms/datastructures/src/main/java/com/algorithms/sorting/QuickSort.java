package com.algorithms.sorting;

public class QuickSort {

    public static void swap(Comparable[] inputArray, int index1, int index2) {
        Comparable temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }

    public static void quickSort(Comparable[] input, int left, int right) {
        if (left < right) {
            int pivotindex = partition(input, left, right);
            quickSort(input, left, pivotindex - 1);
            quickSort(input, pivotindex + 1, right);
        }
    }

    public static int partition(Comparable[] input, int left, int right) {
        int middle = left + (right - left) / 2;

        Comparable pivot = input[middle];

        swap(input, left, middle);

        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (input[i].compareTo(pivot) <= 0) {
                i++;
                if (i >= right)
                    break;
            }
            while (input[j].compareTo(pivot) > 0) {
                j--;
                if (j <= left + 1)
                    break;
            }

            if (j <= i)
                break;
            swap(input, i, j);
            i++;
            j--;
        }
        swap(input, j, left);
        return j;
    }

    public static void main(String args[]) {

        Integer[] input = { 5, 6, 2, 1, 3, 4, 9, 8, 10, 11, 99, 1, 2, 3 };
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
