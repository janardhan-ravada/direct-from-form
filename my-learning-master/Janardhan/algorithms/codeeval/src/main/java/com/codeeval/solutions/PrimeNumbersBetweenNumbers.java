package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrimeNumbersBetweenNumbers {

    public static int numberOfPrimes(int lower, int upper) {
        int noOfPrimes = 0;

        for (int i = lower; i <= upper; i++) {
            int num = i;
            int count = 0;
            for (int j = 1; j <= num / 2; j++) {
                if (num % j == 0) {
                    count++;
                }
            }
            if (count == 1) {
                noOfPrimes++;
                System.out.println(num + "number");
            }
        }
        return noOfPrimes;

    }

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            String numbers[] = line.split(",");
            System.out.println(numberOfPrimes(Integer.parseInt(numbers[0]),
                    Integer.parseInt(numbers[1])));
        }

    }

}
