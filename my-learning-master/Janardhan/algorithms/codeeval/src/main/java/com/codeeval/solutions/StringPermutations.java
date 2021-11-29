package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StringPermutations {

    public static void permute(String input) {
        int length = input.length();
        boolean used[] = new boolean[length];
        StringBuffer output = new StringBuffer(length);
        permutations(input, length, output, used, 0);
    }

    private static void permutations(String input, int length,
            StringBuffer output, boolean used[], int position) {
        if (position == length) {
            System.out.println(output);
            return;
        } else {
            for (int i = 0; i < length; i++) {
                if (!used[i])
                    continue;
                permutations(input, length, output, used, position + 1);
                output.deleteCharAt(output.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
        }
    }

}
