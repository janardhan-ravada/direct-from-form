package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravadaj on 30/08/16.
 */
public class MersennePrime {

    public static boolean isPowerOfTwo(int number) {

        int temp = number;

        while (temp % 2 == 0) {
            temp = temp / 2;
        }

        if (temp == 1) {
            return true;
        } else
            return false;
    }

    public static boolean isPrime(int number) {
        boolean isPrime = false;
        int count = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                count++;
            }
            if (count > 1) {
                break;
            }
        }
        if (count == 1) {
            isPrime = true;
        }

        return isPrime;
    }

    public static boolean isMersennePrime(int number) {
        if (isPrime(number) && isPowerOfTwo(number + 1))
            return true;
        else
            return false;
    }

    public static void main(String args[]) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            int number = Integer.parseInt(line);
            List<Integer> mersenneNumbers = new ArrayList<>();
            for (int i = 1; i <= number; i++) {
                if (isMersennePrime(i)) {
                    mersenneNumbers.add(i);
                }
            }

            for (int i:mersenneNumbers) {
                if(mersenneNumbers.size()==1)
                    System.out.print(i);
                else
                System.out.print(i+",\t");
            }
            System.out.println();
        }

    }
}
