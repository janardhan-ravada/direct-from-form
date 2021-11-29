package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NumberOfStairs {

    public static long fibonacci(int n) {

        if (n == 0 || n == 1)
            return 1;

        long result = 0;
        long first = 1;
        long second = 1;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

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

    public static void main(String args[]) throws Exception {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            int noofstairs = Integer.parseInt(line);
            long[] dataArr = new long[noofstairs + 1];
            fibonacci(dataArr, noofstairs);
            System.out.println(dataArr[noofstairs]);
        }
    }
}
