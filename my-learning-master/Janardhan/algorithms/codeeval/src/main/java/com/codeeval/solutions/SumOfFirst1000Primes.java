package com.codeeval.solutions;

public class SumOfFirst1000Primes {

    public static boolean isPrime(int number) {
        boolean isPrime = false;
        int count = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                count++;
            }
            if (count == 1) {
                isPrime = true;
                break;
            }
        }
        return isPrime;
    }

    public static int sumOfPrimes() {
        int sum = 0;
        int count = 1;
        for (int i = 1; count <= 1000; i++) {
            if (isPrime(i)) {
                sum = sum + i;
            }
        }
        return sum;
    }
    
}
