package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseWord {
    public static String reverse(String input) {
        String[] inputArray = input.split(" ");
        Object[] stack = new Object[inputArray.length];
        String reverse = "";
        for (int i = 0; i < inputArray.length; i++) {
            stack[i] = inputArray[i];
        }

        for (int i = stack.length - 1; i >= 0; i--) {
            reverse = reverse.concat(stack[i].toString()).concat(" ");
        }
        return reverse;
    }

    public static void main(String[] args)
            throws NumberFormatException, IOException {
        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            System.out.println(reverse(line));
        }
    }

}
