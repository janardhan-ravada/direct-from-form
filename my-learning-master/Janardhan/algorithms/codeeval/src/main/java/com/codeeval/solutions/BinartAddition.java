package com.codeeval.solutions;

public class BinartAddition {

    private static String binaryAddition(String binary1, String binary2) {
        int len1 = binary1.length();
        int len2 = binary2.length();

        int len = len1 > len2 ? len1 : len2;
        return null;
    }

    private static String addBinaryNumbers(char b1, char b2) throws Exception {
        if (b1 == '0' && b2 == '0')
            return "0";
        else if (b1 == '0' && b2 == '1')
            return "1";
        else if (b1 == '1' && b2 == '0')
            return "0";
        else if (b1 == '1' && b2 == '1')
            return "10";
        else
            throw new Exception("Invalid binary numbers");
    }

    public static void main(String args[]) {
        String input0 = "1010";
        String input1 = "10";

        // Use as radix 2 because it's binary
        int number0 = Integer.parseInt(input0, 2);
        int number1 = Integer.parseInt(input1, 2);

        int sum = number0 + number1;
        System.out.println(Integer.toBinaryString(sum));
    }
}
