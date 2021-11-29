package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BankNumberValidaton {

    public static int isValid(long number) {
        long oddDigitSum = 0;
        long evenDigitSum = 0;

        while (number > 0) {
            long lastTwodigits = number % 100;
            long evenDigit = (lastTwodigits / 10)*2;
            long oddDigit = lastTwodigits % 10;
            oddDigitSum = oddDigitSum + oddDigit;
            if (evenDigit >= 10) {
                evenDigitSum = evenDigitSum + (evenDigit / 10)
                        + (evenDigit % 10);
            } else {
                evenDigitSum = evenDigitSum + evenDigit;
            }
            number = number / 100;
        }

        long sum = oddDigitSum + evenDigitSum;
        
        if (sum % 10 == 0)
            return 1;
        else
            return 0;
    }

    public static void main(String args[]) throws Exception {
        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while (((line = in.readLine()) != null)) {
            long banknum = Long.parseLong(line.replaceAll(" ", ""));
            System.out.println(isValid(banknum));
        }
    }

}
