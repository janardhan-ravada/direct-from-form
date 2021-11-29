package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StringReverse {

    public static String reverse(String input) {
        Object[] stack = new Object[input.length()];
        String reverse = "";
        for (int i = 0; i < input.length(); i++) {
            stack[i] = input.charAt(i);
        }

        for (int i = stack.length - 1; i >= 0; i--) {
            reverse = reverse.concat(stack[i].toString());
        }
        return reverse;
    }

    public static void main(String[] args)
            throws NumberFormatException, IOException {
        File file = new File("/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            System.out.println(reverse(line));
        }
    }

}
