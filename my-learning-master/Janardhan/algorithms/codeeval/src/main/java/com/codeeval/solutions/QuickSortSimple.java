package com.codeeval.solutions;

import java.util.Scanner;

public class QuickSortSimple {
    

    public static void quickSort(int[] input, int left, int right) {
        if (left < right) {
            int pivotPos = partition(input, left, right);
            quickSort(input, left, pivotPos - 1);
            quickSort(input, pivotPos + 1, right);
        }
    }

    public static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    public static int partition(int[] input, int left, int right) {
        int pivot = input[left];
        int i = left + 1;
        int j = right;

        while (i <= right && j > left) {
            while (i <= right && input[i] <= pivot) {
                i++;
            }

            while (j > left && input[j] >= pivot) {
                j--;
            }

            if (i >= j) {
                swap(input, left, j);
                break;
            }
            swap(input, i, j);
            i++;
            j--;
        }

        return j;

    }

    public static int cutStick(int[] input, int cutLength) {

        int nonZeroCount = 0;
        int j = input.length - 1;

        while (j >= 0) {
            input[j] = input[j] - cutLength;
            if (input[j] > 0)
                nonZeroCount++;
            j--;
        }
        return nonZeroCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputSize = Integer.parseInt(sc.next());
        int[] input = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = Integer.parseInt(sc.next());
        }

        quickSort(input, 0, input.length - 1);

        int nonZeroCount = inputSize;
        while (input[inputSize - 1] > 0) {
            int min = input[inputSize - nonZeroCount];
            System.out.println(nonZeroCount);
            nonZeroCount = cutStick(input, min);
        }
    }


}
