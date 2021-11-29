package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LongestLinesInFile {

    private static String[] data;

    public LongestLinesInFile() {
    }

    public LongestLinesInFile(int size) {
        data = new String[size];
    }

    public static void doParsing(final String line) {
        int pos = 0;

        while (pos < data.length - 1 && data[pos].length() < line.length()) {
            pos++;
        }
        if (pos < data.length) {
            System.arraycopy(data, pos, data, pos + 1, data.length - pos);
            data[pos] = line;
        }
    }

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        int noOflineToPrint = Integer.parseInt(in.readLine());
        LongestLinesInFile f = new LongestLinesInFile(noOflineToPrint);
        while (((line = in.readLine()) != null)) {
            doParsing(line);
        }
        for (int i = data.length; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }

}
