package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumOfDigits {

    public static int sum(int number) {
        int sum = 0;
        while (number > 1) {
            sum = sum + (number % 10);
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            System.out.println(sum(Integer.parseInt(line)));
        }

    }

}
