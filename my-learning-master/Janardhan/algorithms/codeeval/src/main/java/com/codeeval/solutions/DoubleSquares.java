package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DoubleSquares {

    public static int noOfPerfectSqusres(int number) {
        int loop = (int) Math.sqrt(number);
        int noOfPerfectSquares = 0;

        if (loop > 100) {
            loop = 100;
        }

        for (int i = 0; i <= loop; i++) {
            int squareOfNum1 = i * i;
            int diff = number - squareOfNum1;
            int num2 = (int) Math.sqrt(diff);

            if ((num2 < loop) && (squareOfNum1 + (num2 * num2) == number)) {
                noOfPerfectSquares++;
            }

        }
        return noOfPerfectSquares;
    }

    public static void main(String[] args) {
        try {
            File file = new File(
                    "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(noOfPerfectSqusres(Integer.parseInt(line)));
            }
        } catch (Exception e) {
            System.out.println("Invalid arguements");
        }
    }

}
