package com.codeeval.solutions;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static BigInteger calculate(int n, BigInteger[] elementData) {
        if (elementData[n] == null) {
            BigInteger temp = calculate(n - 1, elementData);
            elementData[n] = temp.multiply(temp)
                    .add(calculate(n - 2, elementData));
        }
        return elementData[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger firstElement = new BigInteger(sc.next());
        BigInteger secondElement = new BigInteger(sc.next());
        int requirdElement = Integer.parseInt(sc.next());
        BigInteger[] elementData = new BigInteger[requirdElement];

        elementData[0] = firstElement;
        elementData[1] = secondElement;

        calculate(requirdElement - 1, elementData);

        System.out.println(elementData[requirdElement - 1]);

    }
}
