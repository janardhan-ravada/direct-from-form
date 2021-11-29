package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TrailingString {

    public static int isTrialingString(String line, String trailingStr) {

        String[] lineArray = line.split(" ");
        int size = lineArray.length;
        if (lineArray[size - 1].equals(trailingStr))
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            String lineArr[] = line.split(",");
            System.out.println(isTrialingString(lineArr[0], lineArr[1]));
        }
    }

}
