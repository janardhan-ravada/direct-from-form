package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseSpecificLength {

    public static String reverseSpecificLength(String line, int length) {
        StringBuffer reversedString = new StringBuffer();
        String[] stack = new String[length];

        String inputArray[] = line.split(",");

        for (int i = 0; i < inputArray.length;) {

            int len = 0;

            while ((i < inputArray.length) && (len < length)
                    && (inputArray[i] != null)) {
                stack[len] = inputArray[i];
                len++;
                i++;
            }
            for (int j = stack.length - 1; j >= 0; j--) {
                if (stack[j] != null)
                    reversedString.append(stack[j] + ",");
                stack[j] = null;
            }
        }
        return reversedString.deleteCharAt(reversedString.length() - 1)
                .toString();
    }

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            String lineArr[] = line.split(";");
            System.out.println(reverseSpecificLength(lineArr[0],
                    Integer.parseInt(lineArr[1])));
        }

    }

}
