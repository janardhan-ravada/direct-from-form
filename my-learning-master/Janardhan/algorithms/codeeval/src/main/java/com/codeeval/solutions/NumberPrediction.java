package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NumberPrediction {

    public static String generateNumber() {
        long l = 3000000000l;
        StringBuilder s = new StringBuilder("0");

        while (s.length() < l) {
            String s1 = replaceString(s);
            s.append(s1);
        }
        return s.toString();
    }

    private static String replaceString(StringBuilder s) {
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                 str2.append("1");
            } else if (c == '1')
                str2.append("2");
            else if (c == '2') {
                str2.append("0");
            }
        }
        return str2.toString();
    }

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            String seq = generateNumber();
            while ((line = in.readLine()) != null) {
                if (Long.parseLong(line) > 3000000000l) {
                    throw new Exception();
                }
                System.out.println(seq.charAt(Integer.parseInt(line)));
            }
        } catch (Exception e) {
            System.out.println("Invalid arguements");
        }
    }

}
