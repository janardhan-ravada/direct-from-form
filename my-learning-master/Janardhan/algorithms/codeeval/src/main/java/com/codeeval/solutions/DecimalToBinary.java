package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DecimalToBinary {

    public static String binaryNum(int number) {
        StringBuilder binary = new StringBuilder();

        while (number > 1) {
            int rem = number % 2;
            number = number / 2;
            binary = binary.append(rem);
        }
        binary = binary.append(number);
        return binary.reverse().toString();
    }

    public static void main(String[] args)
            throws NumberFormatException, IOException {
        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            int decimal = Integer.parseInt(line);

            System.out.println(binaryNum(decimal));

        }
    }

}
