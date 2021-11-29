package com.algorithms.sorting;

public class MergeSort {

    public static void mergeSort(Comparable[] input) {

        int low = 0;
        int high = input.length - 1;
        Comparable[] temp = new Comparable[input.length];
        divideAndMerge(input, low, high, temp);

        //System.arraycopy(temp, 0, input, 0, input.length);
    }

    public static void divideAndMerge(Comparable[] input, int low, int high,
            Comparable[] temp) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            divideAndMerge(input, low, mid, temp);
            divideAndMerge(input, mid + 1, high, temp);
            merge(input, low, mid, high, temp);
        }
    }

    public static void merge(Comparable[] input, int low, int mid, int high,
            Comparable[] temp) {

        for (int i = low; i <= high; i++) {
            temp[i] = input[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                input[k] = temp[i];
                i++;
            } else {
                input[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            input[k] = temp[i];
            k++;
            i++;
        }

    }

    public static void main(String[] args) {

        Integer[] input = {1,2};
        mergeSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

}
