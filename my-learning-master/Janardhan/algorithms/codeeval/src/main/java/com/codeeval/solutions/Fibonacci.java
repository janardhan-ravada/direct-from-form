package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fibonacci {

    public static long fibonacci(long dataArr[], int n) {
        long fib = 0;
        if (n == 0)
            fib = 0;
        else if (n == 1 || n == 2) {
            fib = 1;
        } else {
            fib = fibonacci(dataArr, n - 1) + fibonacci(dataArr, n - 2);
        }
        dataArr[n] = fib;
        return fib;
    }

    public static void main(String[] args)
            throws NumberFormatException, IOException {
        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            int n = Integer.parseInt(line);
            long[] dataArr = new long[n + 1];
            fibonacci(dataArr, n);
            System.out.println(dataArr[n]);
        }
    }

}
