package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LongestWordInSentence {

    public static String longWord(String line) {
        String longWord = "";
        String lineArr[] = line.split(" ");

        for (String word : lineArr) {
            if (word.length() > longWord.length()) {
                longWord = word;
            }
        }
        return longWord;
    }

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            System.out.println(longWord(line));
        }

    }

}
